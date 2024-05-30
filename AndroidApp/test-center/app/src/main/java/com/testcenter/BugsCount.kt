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
class BugsCount : Activity() {

    var textViewNumero: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bugs_count)

        val webView = WebView(this)
        webView.getSettings().setJavaScriptEnabled(true)



        var customHTML = "<html><body>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">Number of Mobile API bugs</p>" +
                "    <p align=\"center\">" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/mobileApiCount\"\n" +
                "    width=\"50\" height=\"100\"\n" +
                "    style=\"-ms-zoom: 2.75;\n" +
                "        -moz-transform: scale(2.75);\n" +
                "        -moz-transform-origin: 0 0;\n" +
                "        -o-transform: scale(2.75);\n" +
                "        -o-transform-origin: 0 0;\n" +
                "        -webkit-transform: scale(2.75);\n" +
                "        -webkit-transform-origin: 0 0;\"" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">Number of Web API bugs</p>" +
                "    <p align=\"center\">" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/webApiCount\"\n" +
                "    width=\"50\" height=\"100\"\n" +
                "    style=\"-ms-zoom: 2.75;\n" +
                "        -moz-transform: scale(2.75);\n" +
                "        -moz-transform-origin: 0 0;\n" +
                "        -o-transform: scale(2.75);\n" +
                "        -o-transform-origin: 0 0;\n" +
                "        -webkit-transform: scale(2.75);\n" +
                "        -webkit-transform-origin: 0 0;\"" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">Number of Android bugs</p>" +
                "    <p align=\"center\">" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/androidCount\"\n" +
                "    width=\"50\" height=\"100\"\n" +
                "    style=\"-ms-zoom: 2.75;\n" +
                "        -moz-transform: scale(2.75);\n" +
                "        -moz-transform-origin: 0 0;\n" +
                "        -o-transform: scale(2.75);\n" +
                "        -o-transform-origin: 0 0;\n" +
                "        -webkit-transform: scale(2.75);\n" +
                "        -webkit-transform-origin: 0 0;\"" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">Number of iOS bugs</p>" +
                "    <p align=\"center\">" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/iosCount\"\n" +
                "    width=\"50\" height=\"100\"\n" +
                "    style=\"-ms-zoom: 2.75;\n" +
                "        -moz-transform: scale(2.75);\n" +
                "        -moz-transform-origin: 0 0;\n" +
                "        -o-transform: scale(2.75);\n" +
                "        -o-transform-origin: 0 0;\n" +
                "        -webkit-transform: scale(2.75);\n" +
                "        -webkit-transform-origin: 0 0;\"" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "    <p style=\"border-top: 4px solid rgb(81,179,37);border-radius: 4px;text-align: center;margin-top:30px\">Number of Web bugs</p>" +
                "    <p align=\"center\">" +
                "    <iframe class=\"iframe\" src=\"http://10.169.101.169:5000/webCount\"\n" +
                "    width=\"50\" height=\"50\"\n" +
                "    style=\"-ms-zoom: 2.75;\n" +
                "        -moz-transform: scale(2.75);\n" +
                "        -moz-transform-origin: 0 0;\n" +
                "        -o-transform: scale(2.75);\n" +
                "        -o-transform-origin: 0 0;\n" +
                "        -webkit-transform: scale(2.75);\n" +
                "        -webkit-transform-origin: 0 0;\"" +
                "    frameBorder=\"0\"\n" +
                "    scrolling=\"no\"\n" +
                "    seamless=\"seamless\">" +
                "    </iframe>\n" +
                "    </p>" +
                "</body></html>"
        webView.loadData(customHTML, "text/html", "UTF-8")
        setContentView(webView)
    }


    companion object {
        var idValue: String? = null
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.main) {
            val i = Intent(this@BugsCount, MainActivity::class.java)
            startActivity(i)
        }
    }
}