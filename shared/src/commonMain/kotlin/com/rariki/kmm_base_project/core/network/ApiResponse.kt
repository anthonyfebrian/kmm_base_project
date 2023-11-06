package com.rariki.kmm_base_project.core.network

sealed class ApiResponse<out T, out E> {

    data class Success<T>(val body: T) : ApiResponse<T, Nothing>()

    sealed class Error<E> : ApiResponse<Nothing, E>() {
        /**
         * Represents server errors.
         * @param code HTTP Status code
         * @param errorBody Response body
         * @param errorMessage Custom error message
         */
        data class HttpError<E>(
            val code: Int,
            val errorBody: E?,
            val errorMessage: String?,
        ) : Error<E>()

        /**
         * Represent SerializationExceptions.
         * @param message Detail exception message
         */
        data class SerializationError(
            val message: String?,
        ) : Error<Nothing>()

        /**
         * Represent other exceptions.
         * @param exception Exception
         */
        data class GenericError(
            val exception: Exception?,
        ) : Error<Nothing>()
    }
}