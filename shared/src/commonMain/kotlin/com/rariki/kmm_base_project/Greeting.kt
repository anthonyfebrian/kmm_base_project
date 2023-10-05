package com.rariki.kmm_base_project

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class Greeting {
    private val client = HttpClient()
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello aaaa, ${platform.name}!"
    }

    suspend fun textOnline(): String {
        val response = client.get("https://ktor.io/docs/")
        return response.bodyAsText()
    }
}