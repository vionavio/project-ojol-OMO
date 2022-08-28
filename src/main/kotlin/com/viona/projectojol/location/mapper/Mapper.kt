package com.viona.projectojol.location.mapper

import com.viona.projectojol.location.entity.Coordinate
import com.viona.projectojol.location.entity.Location
import com.viona.projectojol.location.entity.LocationHereApiResult
import com.viona.projectojol.location.entity.LocationHereRouteResult
import com.viona.projectojol.location.util.PolylineEncoderDecoder

object Mapper {
    fun mapLocationHereToLocation(locationSearchResult: LocationHereApiResult): List<Location> {
        return locationSearchResult.items?.map {
            val address = Location.Address(
                city = it?.address?.city.orEmpty(),
                country = it?.address?.countryName.orEmpty(),
                distric = it?.address?.district.orEmpty()
            )
            Location(
                name = it?.title.orEmpty(),
                address = address,
                coordinate = Coordinate(it?.position?.lat ?: 0.0, it?.position?.lng ?: 0.0)
            )
        }.orEmpty()
    }

    fun mapRoutesHereToRoutes(locationResult: LocationHereRouteResult): List<Coordinate> {
        val polylineString = locationResult.routes
            ?.firstOrNull()
            ?.sections
            ?.firstOrNull()
            ?.polyline.orEmpty()

        return PolylineEncoderDecoder.decode(polylineString)
            .map { Coordinate(it.lat, it.lng) }
    }
}