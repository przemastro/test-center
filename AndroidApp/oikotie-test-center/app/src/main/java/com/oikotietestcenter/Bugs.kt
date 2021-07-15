package com.oikotietestcenter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.TextView
import com.squareup.okhttp.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException


/**
 * Created by Przemek on 24.10.2020.
 */
class Bugs : Activity() {

    var textViewNumero: TextView? = null
    val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bugs)

        val webView = WebView(this)
        webView.getSettings().setJavaScriptEnabled(true)



        val url = "http://10.169.101.169:5000/mobileApiBugs"

        get(url, object: Callback {
            override fun onFailure(request: Request?, e: IOException?) {
                println("Request Failure.")
            }

            override fun onResponse(response: Response?) {
                val responseData = response?.body()?.string()
                runOnUiThread{
                    try {
                        var json = JSONObject(responseData)
                        println("Request Successful!!")
                        println(json)
                        val responseObject = json.getJSONObject("response")
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }

        })

        var customHTML = "<html><body>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">Mobile API bugs by severity</p>" +
                "    <p align=\"center\" style=\"margin-left:-70px;margin-top:-20px;\">" +
                "    <iframe " +
                "    class=\"iframe\" src=\"http://10.169.101.169:5000/mobileApiBugs\"\n" +
                "    width=\"400\" height=\"220\"\n" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">Web API bugs by severity</p>" +
                "    <p align=\"center\" style=\"margin-left:-70px;margin-top:-20px;\">" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/webApiBugs\"\n" +
                "    width=\"400\" height=\"220\"\n" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">Android bugs by severity</p>" +
                "    <p align=\"center\" style=\"margin-left:-70px;margin-top:-20px;\">" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/androidBugs\"\n" +
                "    width=\"400\" height=\"220\"\n" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">iOS bugs by severity</p>" +
                "    <p align=\"center\" style=\"margin-left:-70px;margin-top:-20px;\">" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/iosBugs\"\n" +
                "    width=\"400\" height=\"220\"\n" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">Number of Web bugs</p>" +
                "    <p align=\"center\" style=\"margin-left:-70px;margin-top:-20px;\">" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/webBugs\"\n" +
                "    width=\"400\" height=\"220\"\n" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "</body></html>"
        webView.loadData(customHTML, "text/html", "UTF-8")
        setContentView(webView)
    }

    fun get(url: String, callback: Callback): Call {
        val request = Request.Builder()
                .url(url)
                .build()

        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }

    companion object {
        var idValue: String? = null
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.main) {
            val i = Intent(this@Bugs, MainActivity::class.java)
            startActivity(i)
        }
    }
}