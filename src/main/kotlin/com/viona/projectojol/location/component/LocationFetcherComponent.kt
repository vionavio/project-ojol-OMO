package com.viona.projectojol.location.component

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException
import com.viona.projectojol.location.entity.Coordinate
import com.viona.projectojol.location.entity.LocationHereApiResult
import com.viona.projectojol.location.entity.LocationHereRouteResult
import okhttp3.OkHttpClient
import okhttp3.Request
import org.bson.json.JsonParseException
import org.springframework.stereotype.Component

@Component
class LocationFetcherComponent {

    private val client = OkHttpClient()

    private inline fun <reified T> getHttp(url: String): Result<T> {
        return try {
            val request = Request.Builder()
                .url(url)
                .build()

            val response = client.newCall(request).execute()
            val body = response.body
            val bodyString = body?.string()
            if (response.isSuccessful) {
                val data = ObjectMapper().readValue(bodyString, T::class.java)
                Result.success(data)
            } else {
                val throwable = IllegalArgumentException(response.message)
                Result.failure(throwable)
            }
        } catch (e: JsonParseException) {
            Result.failure(e)
        } catch (e: InvalidDefinitionException) {
            Result.failure(e)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }

    fun searchLocation(name: String, coordinate: Coordinate): Result<LocationHereApiResult> {
        val coordinateString = "${coordinate.latitude},${coordinate.longitude}"
        val url = SEARCH_LOC
            .replace(Key.COORDINATE, coordinateString)
            .replace(Key.NAME, name)
        return getHttp(url)
    }

    fun reserveLocation(coordinate: Coordinate): Result<LocationHereApiResult> {
        val coordinateString = "${coordinate.latitude},${coordinate.longitude}"
        val url = RESERVE_LOC
            .replace(Key.COORDINATE, coordinateString)
        return getHttp(url)
    }

    fun getRoutes(origin: Coordinate, destination: Coordinate): Result<LocationHereRouteResult> {
        val coordinateOriginString = "${origin.latitude},${origin.longitude}"
        val coordinateDestinationString = "${destination.latitude},${destination.longitude}"

        val url = ROUTES_POLYLINE_LOC
            .replace(Key.COORDINATE_ORIGIN, coordinateOriginString)
            .replace(Key.COORDINATE_DESTINATION, coordinateDestinationString)

        return getHttp(url)
    }



    companion object {
        const val SEARCH_LOC = "https://discover.search.hereapi.com/v1/discover?at={{coordinate}}&limit=2&q={{name}}&apiKey=m_fbKitexjoJSjrMZHg3F3FZZuv0K7iLXnunwsA-0F0"
        const val RESERVE_LOC = "https://revgeocode.search.hereapi.com/v1/revgeocode?at={{coordinate}}&lang=en-US&apiKey=m_fbKitexjoJSjrMZHg3F3FZZuv0K7iLXnunwsA-0F0"
        const val ROUTES_POLYLINE_LOC = "https://router.hereapi.com/v8/routes?transportMode=scooter&origin={{coordinate_origin}}&destination={{coordinate_destination}}&return=polyline&apikey=m_fbKitexjoJSjrMZHg3F3FZZuv0K7iLXnunwsA-0F0"
    }

    object Key {
        const val COORDINATE = "{{coordinate}}"
        const val NAME = "{{name}}"
        const val COORDINATE_ORIGIN = "{{coordinate_origin}}"
        const val COORDINATE_DESTINATION = "{{coordinate_destination}}"

        fun parse(url: String, key: String, any: String): String {
            return url.replace(key, any)
        }
    }
}
