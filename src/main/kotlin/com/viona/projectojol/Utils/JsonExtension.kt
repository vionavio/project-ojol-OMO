package com.viona.projectojol.Utils

import com.fasterxml.jackson.databind.ObjectMapper

fun <T: Any, U: Any>T.safeCastTo(clazz: Class<U>): U {
    val json = ObjectMapper().writeValueAsString(this)
    return ObjectMapper().readValue(json, clazz)
}