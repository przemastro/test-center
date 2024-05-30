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
class Performance : Activity() {
    var textViewNumero: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.performance)

        val webView = WebView(this)
        webView.getSettings().setJavaScriptEnabled(true)

        var customHTML = "<html><body>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">API Performance Monitoring</p>" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/performance\"\n" +
                "    width=\"670\" height=\"250\"\n" +
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
            val i = Intent(this@Performance, MainActivity::class.java)
            startActivity(i)
        }
    }
}