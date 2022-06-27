package com.viona.projectojol

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class MainExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [OjolException::class])
    fun handleThrowable(throwable: OjolException): ResponseEntity<BaseResponse<Empty>> {
        return ResponseEntity(BaseResponse.failure(throwable.message ?: "failure"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}