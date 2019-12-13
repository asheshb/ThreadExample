package com.example.threadexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        downloadText.setOnClickListener {
            val data = getDataFromNetwork("https://www.google.com/")
            text_data.text = data

            //region
            Thread(object: Runnable{
                override fun run(){
                    val data = getDataFromNetwork("https://www.google.com/")
                    runOnUiThread {
                        text_data.text = data
                    }
                }
            }).start()
            //endregion

            //region
//            //Single Abstract Method (SAM)
//            Thread{
//                val data = getDataFromNetwork("https://www.google.com/")
//                runOnUiThread {
//                    //Log.d(TAG, "Inside runOnUiThread: " + Thread.currentThread().name)
//                    text_data.text = data
//                }
//            }.start()
            //endregion

        }
    }
}
