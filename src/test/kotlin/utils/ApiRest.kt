package utils

import io.restassured.RestAssured
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import org.json.simple.JSONObject
import utils.Configuration.setApiUrl
import java.util.concurrent.TimeUnit


open class ApiRest {

    private var lastResponse: Response? = null
    private var lastRequestBody: String? = null
    private var lastToken: String? = null

    /**
     * Sends request to given endpoint.
     *
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     * @param body     Body to be attached to request.
     * @param token    Authorization token to be used.
     */
    open fun request(apiUrl: String, method: String, endpoint: String, body: String, token: String) {
        val requestUrl: String = apiUrl + endpoint
        lastRequestBody = body
        val request: RequestSpecification = RestAssured.given()
        request.accept("*/*")
        if (body != "") {
            val map = body.split(",").associateTo(HashMap()) {
                val (left, right) = it.split("=")
                left to right
            }
            map.forEach { (key, value) -> request.formParam("$key", "$value") }
            request.header("Content-Type", "application/x-www-form-urlencoded")
        }
        if (token != "") {
            request.header("Authorization", "Bearer $token")
        }
        lastResponse = when (method.toUpperCase()) {
            "GET" -> request.get(requestUrl)
            "HEAD" -> request.head(requestUrl)
            "POST" -> request.post(requestUrl)
            "PUT" -> request.put(requestUrl)
            "DELETE" -> request.delete(requestUrl)
            "OPTIONS" -> request.options(requestUrl)
            "PATCH" -> request.patch(requestUrl)
            else -> null
        }
    }

    /**
     * Sends request to given endpoint.
     *
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     */
    open fun request(method: String, endpoint: String) {
        request(setApiUrl(), method, endpoint, "", "")
    }

    /**
     * Sends request to given endpoint.
     *
     * @param url   HTTP url to be used.
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     * @param body  HTTP body to be used.
     */
    open fun request(url: String, method: String, endpoint: String, body: String) {
        request(url, method, endpoint, "", "")
    }

    /**
     * Sends request to given endpoint.
     *
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     */
    open fun request(method: String, endpoint: String, body: String) {
        request(setApiUrl(), method, endpoint, body, "")
    }

    /**
     * Returns last HTTP response.
     *
     * @return lastResponse variable.
     */
    open fun getLastResponse(): Response? {
        return lastResponse
    }

    open fun reportResponseTime(endpoint: String?) {
        MongoConnector.responseTime(lastResponse?.getTimeIn(TimeUnit.MILLISECONDS), endpoint)
    }

    /**
     * Validate last HTTP response.
     *
     * @return lastResponse variable.
     */
    open fun validateLastResponse(): Boolean {
        return checkForDuplicates(lastResponse)
    }

    /**
     * Validate last HTTP response count.
     *
     * @return lastResponse variable.
     */
    open fun validateLastCount(): Boolean {
        var count = lastResponse?.then()?.extract()?.jsonPath()?.getInt("count");
        return count!! != 0
    }

    private fun <T> checkForDuplicates(vararg array: T): Boolean {
        val set: MutableSet<T> = HashSet()
        for (e in array) {
            if (set.contains(e)) return true
            if (e != null) set.add(e)
        }
        return false
    }

    /**
     * Return last HTTP response body.
     *
     * @return lastResponse body as string.
     */
    open fun getLastResponseBody(): String? {
        return lastResponse?.body?.asString()
    }

    /**
     * Return last received token
     *
     * @return lastResponse body token as string.
     */
    open fun getLastResponseBodyToken(): String? {
        return lastResponse?.then()?.extract()?.path<String>("token")
    }


    /**
     * Returns last HTTP request body.
     *
     * @return lastRequestBody variable.
     */
    open fun getLastRequestBody(): String? {
        return lastRequestBody
    }

    /**
     * Sends request to given endpoint and reads token.
     *
     * @param login    Login to be used for authentication.
     * @param password Password to be used for authentication.
     */
    private fun authentication(url: String, login: String, password: String){
        val requestParams = JSONObject()
        println(url)
        println(login)
        println(password)
        requestParams["user"] = login
        requestParams["password"] = password
        requestParams["type"] = "ot"
        val request: RequestSpecification = RestAssured.given()
           .header("Content-Type", "application/json")
                .body(requestParams.toJSONString())
        lastResponse = request.post("$url/api/v1/user/login")
        lastToken = getLastResponseBodyToken()
    }

    /**
     * Sends request to given endpoint and reads token.
     *
     * @param login    Login to be used for authentication.
     * @param password Password to be used for authentication.
     * @param url Url to be used for authentication.
     */
    private fun webAuthentication(url: String, login: String, password: String){
        val requestParams = JSONObject()
        requestParams["username"] = login
        requestParams["password"] = password
        requestParams["type"] = "ot-apts"
        println(requestParams)
        val request: RequestSpecification = RestAssured.given()
                .header("username", "example@gmail.com")
                .header("password", "test1234")
                .header("Content-Type", "application/json")
                .header("Accept","application/json" )
                .body(requestParams)
        lastResponse = request.post("https://example/client/v2/login")
        println(lastResponse?.then()?.statusCode(200))

    }


    /**
     * Gets token.
     *
     * @param login    Login to be used for authentication.
     * @param password Password to be used for authentication.
     */
    open fun getToken(login: String, password: String): String {
        return authentication(setApiUrl(), login, password).toString()
    }

    /**
     * Gets token.
     *
     * @param login    Login to be used for authentication.
     * @param password Password to be used for authentication.
     */
    open fun getWebToken(url: String, login: String, password: String): String {
        return webAuthentication(url, login, password).toString()
    }

    /**
     * Sends authenticated request to given endpoint.
     *
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     */
    fun sendAuthenticatedRequest(method: String, endpoint: String) {
        lastToken?.let { request(setApiUrl(), method, endpoint, "", it) }
    }

    /**
     * Sends authenticated request to given endpoint.
     *
     * @param method   HTTP method to be used.
     * @param endpoint Endpoint to be called.
     * @param body Body to be sent.
     */
    fun sendAuthenticatedRequestWithBody(method: String, endpoint: String, body: String) {
        lastToken?.let { request(setApiUrl(), method, endpoint, body, it) }
    }
}
