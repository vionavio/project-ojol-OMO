package com.viona.projectojol.location.services

import com.viona.projectojol.location.component.LocationFetcherComponent
import com.viona.projectojol.location.entity.Coordinate
import com.viona.projectojol.location.entity.Location
import com.viona.projectojol.location.entity.Routes
import com.viona.projectojol.location.mapper.Mapper
import com.viona.projectojol.orThrow
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

    override fun reserveLocation(coordinate: Coordinate): Result<List<Location>> {
        return fetcher.reserveLocation(coordinate).map {
            Mapper.mapLocationHereToLocation(it)
        }
    }

    override fun getRoutesLocation(origin: Coordinate, destination: Coordinate): Result<Routes> {
        return fetcher.getRoutes(origin, destination).map {
            Routes(Mapper.mapRoutesHereToRoutes(it))
        }
    }

}