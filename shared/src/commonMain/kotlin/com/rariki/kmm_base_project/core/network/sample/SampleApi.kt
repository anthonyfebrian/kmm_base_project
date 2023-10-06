package com.rariki.kmm_base_project.core.network.sample

import com.rariki.kmm_base_project.core.network.ApiConfig
import com.rariki.kmm_base_project.core.network.ApiResponse
import com.rariki.kmm_base_project.core.network.safeRequest
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import io.ktor.http.path

class SampleApi {
    private val httpClient = ApiConfig.httpClient

    suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get("launches").body()
    }

    suspend fun safeGetAllLaunches():ApiResponse<List<RocketLaunch>>  {
        return httpClient.safeRequest {
            url {
                method = HttpMethod.Get
                path("launches")
            }
        }
    }
}