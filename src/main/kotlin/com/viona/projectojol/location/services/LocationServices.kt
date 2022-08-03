package com.viona.projectojol.location

interface LocationServices {
    fun searchLocation(name: String, coordinate: Coordinate): Result<List<Location>>
    fun reserveLocation(coordinate: Coordinate): Result<Any>
    fun getRoutesLcation(origin: Coordinate, destination: Coordinate): Result<Any>
}