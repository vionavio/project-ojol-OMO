package com.viona.projectojol.location

import com.viona.projectojol.BaseResponse
import com.viona.projectojol.toResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/location")
class LocationController {

    @Autowired
    private lateinit var locationServices: LocationServices

    @GetMapping("/search")
    fun searchLocation(
        @RequestParam(value = "name") name: String,
        @RequestParam(value = "coordinate") coordinate: String
    ): BaseResponse<List<Location>> {
        val coordinateStrings = coordinate.split(",")
        val lat = coordinateStrings[0].toDoubleOrNull() ?: 0.0
        val lon = coordinateStrings[1].toDoubleOrNull() ?: 0.0
        val coordinates = Coordinate(lat, lon)
        return locationServices.searchLocation(name, coordinates).toResponses()
    }
}