package com.example.threadexample

import java.net.HttpURLConnection
import java.net.URL

fun getDataFromNetwork(url: String): String{
    val urlConnection = URL(url).openConnection()
            as HttpURLConnection
    try {
        return urlConnection.inputStream.bufferedReader().readText()
    } finally {
        urlConnection.disconnect()
    }
}