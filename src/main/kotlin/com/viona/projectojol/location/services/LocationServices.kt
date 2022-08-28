package com.viona.projectojol.location.services

import com.viona.projectojol.location.entity.Coordinate
import com.viona.projectojol.location.entity.Location
import com.viona.projectojol.location.entity.Routes

interface LocationServices {
    fun searchLocation(name: String, coordinate: Coordinate): Result<List<Location>>
    fun reserveLocation(coordinate: Coordinate): Result<List<Location>>
    fun getRoutesLocation(origin: Coordinate, destination: Coordinate): Result<Routes>
}