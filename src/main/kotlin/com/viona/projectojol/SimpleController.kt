package com.viona.projectojol

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/test")
class SimpleController {

    @GetMapping("/ping")
    fun ping(): BaseResponse<String> {
        return BaseResponse(
            status = true,
            message = "Success",
            data = "Halo viona, semangat"
        )
    }
}