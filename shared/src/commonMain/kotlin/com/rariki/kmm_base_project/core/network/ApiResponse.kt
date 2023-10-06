package com.rariki.kmm_base_project.core.network

sealed class ApiResponse<out T> {

    data class Success<T>(val body: T) : ApiResponse<T>()

    sealed class Error:ApiResponse<Nothing>() {
        /**
         * Represents server errors.
         * @param code HTTP Status code
         * @param errorBody Response body
         * @param errorMessage Custom error message
         */
        data class HttpError(
            val code: Int,
            val errorBody: String?,
            val errorMessage: String?,
        ) : Error()

        /**
         * Represent SerializationExceptions.
         * @param message Detail exception message
         */
        data class SerializationError(
            val message: String?,
        ) : Error()

        /**
         * Represent other exceptions.
         * @param exception Exception
         */
        data class GenericError(
            val exception: Exception?,
        ) : Error()
    }
}