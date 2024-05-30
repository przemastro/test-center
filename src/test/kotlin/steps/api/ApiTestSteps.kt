package steps.api

import org.testng.Assert
import utils.ApiRest


class ApiTestSteps : ApiRest() {

    @io.cucumber.java.en.When("I send {string} request to {string} endpoint")
    fun sendRequestToEndpoint(method: String, endpoint: String) {
        request(method, endpoint)
    }

    @io.cucumber.java.en.When("I send {string} request to {string} url and {string} endpoint")
    fun sendRequestToEndpointWithDefinedUrl(method: String, url: String, endpoint: String) {
        request(url, method, endpoint, "")
    }

    @io.cucumber.java.en.When("I send {string} request to {string} url and {string} endpoint with body {string}")
    fun sendRequestToEndpointWithDefinedUrlAndBody(method: String, url: String, endpoint: String, body: String) {
        request(url, method, endpoint, body)
    }

    @io.cucumber.java.en.When("I send {string} request to {string} endpoint with parameters {string}")
    fun sendRequestToEndpointWithParameters(method: String, endpoint: String, parameters: String) {
        var endpointWithParameters = endpoint + parameters
        request(method, endpointWithParameters)
    }

    @io.cucumber.java.en.When("I send {string} request to {string} endpoint with body {string}")
    fun sendRequestToEndpoint(method: String, endpoint: String, body: String) {
        request(method, endpoint, body)
    }

    @io.cucumber.java.en.When("I get status code {string}")
    fun getStatusCode(code: String?) {
        Assert.assertEquals(getLastResponse()?.statusCode(), Integer.parseInt(code))
    }

    @io.cucumber.java.en.When("I get response time for {string} endpoint")
    fun getResponseTime(endpoint: String?) {
        reportResponseTime(endpoint)
    }

    @io.cucumber.java.en.When("I verify response does not contain duplicates")
    fun verifyDuplicatesInResponse() {
        Assert.assertFalse(validateLastResponse())
    }

    @io.cucumber.java.en.When("I verify count is not equal 0")
    fun verifyCountIsNotEqualZero() {
        Assert.assertTrue(validateLastCount())
    }

    @io.cucumber.java.en.When("I send {string} request authenticated with {string} and {string} credentials to {string} endpoint")
    fun sendAuthenticatedRequest(method: String, login: String, password: String, endpoint: String) {
        getToken(login, password)
        sendAuthenticatedRequest(method, endpoint)
    }

    @io.cucumber.java.en.When("I send {string} request authenticated with {string} and {string} credentials to {string} endpoint with body {string}")
    fun sendAuthenticatedRequestWithBody(method: String, login: String, password: String, endpoint: String, body: String) {
        getToken(login, password)
        sendAuthenticatedRequestWithBody(method, endpoint, body)
    }

    @io.cucumber.java.en.When("I send {string} request authenticated with {string} and {string} credentials to {string} url and {string} endpoint")
    fun sendWebAuthenticatedRequestWithBody(method: String, login: String, password: String, url: String, endpoint: String) {
        getWebToken(url, login, password)
    }
}

