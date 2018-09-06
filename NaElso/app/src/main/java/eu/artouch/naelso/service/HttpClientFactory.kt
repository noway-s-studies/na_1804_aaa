package eu.artouch.naelso.service

import okhttp3.OkHttpClient

class HttpClientFactory{
    companion object {
        fun getClient(): OkHttpClient {
            return OkHttpClient.Builder().build()
        }
    }
}