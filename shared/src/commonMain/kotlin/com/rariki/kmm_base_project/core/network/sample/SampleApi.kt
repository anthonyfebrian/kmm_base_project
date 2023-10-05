package com.rariki.kmm_base_project.core.network.sample

import com.rariki.kmm_base_project.core.network.ApiConfig
import io.ktor.client.call.body
import io.ktor.client.request.get

class SampleApi {
    private val httpClient = ApiConfig.httpClient

    suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get("launches").body()
    }
}