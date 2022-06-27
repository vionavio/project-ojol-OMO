package com.viona.projectojol


data class BaseResponse<T>(
    var status: Boolean = false,
    var message: String = "success",
    var data: T? = null
) {
    companion object {
        fun <T>success(data: T?): BaseResponse<T> {
            return BaseResponse(status = true, data = data)
        }

        fun <T>failure(message: String): BaseResponse<T>{
            return BaseResponse(status = false, message = message)
        }
    }
}