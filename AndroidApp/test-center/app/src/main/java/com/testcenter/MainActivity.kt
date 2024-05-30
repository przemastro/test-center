package com.testcenter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.squareup.okhttp.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    fun onButtonClick(v: View) {
        if (v.id == R.id.app) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("app"))
            startActivity(browserIntent)
        }

        if (v.id == R.id.jenkins) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://10.169.101.169:9090/"))
            startActivity(browserIntent)
        }

        if (v.id == R.id.stf) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://10.169.101.169:7100/#!/devices"))
            startActivity(browserIntent)
        }
        if (v.id == R.id.reload) {

            val url = ""
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
        }

        if (v.id == R.id.tests) {
            val client = OkHttpClient()
            val mediaType: MediaType = MediaType.parse("application/json")
            val body = RequestBody.create(mediaType, "")
            //val body: RequestBody = RequestBody.create(mediaType, "j_username=admin&j_password=admin&from=%2F&Submit=Sign+in")
            val request = Request.Builder()
                    .url("http://10.169.101.169:9090/j_acegi_security_check?j_username=admin&j_password=admin&from=/")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .build()
            println("before request")
            val response: Response = client.newCall(request).execute()
            println(response.body().string())
            val i = Intent(this@MainActivity, Tests::class.java)
            startActivity(i)
        }

        if (v.id == R.id.bugs) {
            val i = Intent(this@MainActivity, Bugs::class.java)
            startActivity(i)
        }

        if (v.id == R.id.bugs_count) {
            val i = Intent(this@MainActivity, BugsCount::class.java)
            startActivity(i)
        }

        if (v.id == R.id.performance) {
            val i = Intent(this@MainActivity, Performance::class.java)
            startActivity(i)
        }
    }

    fun get(url: String, callback: Callback): Call {
        val request = Request.Builder()
                .url(url)
                .build()

        val call = client.newCall(request)
        call.enqueue(callback)
        return call
    }

}