package com.rariki.kmm_base_project.core.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

object ApiConfig {

    val httpClient = HttpClient {
        defaultRequest {
            url("https://api.spacexdata.com/v5/")
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                }
            )
        }

        expectSuccess = true
    }
}

suspend inline fun <reified T, reified E> HttpClient.safeRequest(
    block: HttpRequestBuilder.() -> Unit,
): ApiResponse<T, E> =
    try {
        val response = request { block() }
        ApiResponse.Success(response.body())
    } catch (exception: ClientRequestException) {
        val response = exception.response

        ApiResponse.Error.HttpError(
            code = response.status.value,
            errorBody = response.body(),
            errorMessage = exception.message,
        )
    } catch (e: SerializationException) {
        ApiResponse.Error.SerializationError(e.message)
    } catch (e: Exception) {
        ApiResponse.Error.GenericError(e)
    }