package com.viona.projectojol.location

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LocationServicesImpl(
    @Autowired
    private val fetcher: LocationFetcherComponent
): LocationServices {
    override fun searchLocation(name: String, coordinate: Coordinate): Result<List<Location>> {
        return fetcher.searchLocation(name, coordinate).map {
            Mapper.mapLocationHereToLocation(it)
        }
    }

    override fun reserveLocation(coordinate: Coordinate): Result<Any> {
        return Result.success(1)
    }

    override fun getRoutesLcation(origin: Coordinate, destination: Coordinate): Result<Any> {
        return Result.success(1)
    }

}