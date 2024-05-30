package com.testcenter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.TextView

/**
 * Created by Przemek on 24.10.2020.
 */
class Tests : Activity() {
    var textViewNumero: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tests)

        val webView = WebView(this)
        webView.getSettings().setJavaScriptEnabled(true)

        var customHTML = "<html><body>" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:9090/job/mobile-api-prod/allure/\"\n" +
                "    width=\"470\" height=\"250\"\n" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:9090/job/mobile-api-prod/allure/\"\n" +
                "    width=\"470\" height=\"250\"\n" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "</body></html>"
        webView.loadData(customHTML, "text/html", "UTF-8")
        setContentView(webView)
    }

    companion object {
        var idValue: String? = null
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.main) {
            val i = Intent(this@Tests, MainActivity::class.java)
            startActivity(i)
        }
    }
}