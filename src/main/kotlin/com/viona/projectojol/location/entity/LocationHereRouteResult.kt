package com.viona.projectojol.location.entity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class LocationHereRouteResult(
    @JsonProperty("routes")
    val routes: List<Route?>?
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Route(
        @JsonProperty("id")
        val id: String?,
        @JsonProperty("sections")
        val sections: List<Section?>?
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Section(
            @JsonProperty("arrival")
            val arrival: Arrival?,
            @JsonProperty("departure")
            val departure: Departure?,
            @JsonProperty("id")
            val id: String?,
            @JsonProperty("polyline")
            val polyline: String?,
            @JsonProperty("transport")
            val transport: Transport?,
            @JsonProperty("type")
            val type: String?
        ) {
            @JsonIgnoreProperties(ignoreUnknown = true)
            data class Arrival(
                @JsonProperty("place")
                val place: Place?,
                @JsonProperty("time")
                val time: String?
            ) {
                @JsonIgnoreProperties(ignoreUnknown = true)
                data class Place(
                    @JsonProperty("location")
                    val location: Location?,
                    @JsonProperty("originalLocation")
                    val originalLocation: OriginalLocation?,
                    @JsonProperty("type")
                    val type: String?
                ) {
                    @JsonIgnoreProperties(ignoreUnknown = true)
                    data class Location(
                        @JsonProperty("lat")
                        val lat: Double?,
                        @JsonProperty("lng")
                        val lng: Double?
                    )

                    @JsonIgnoreProperties(ignoreUnknown = true)
                    data class OriginalLocation(
                        @JsonProperty("lat")
                        val lat: Double?,
                        @JsonProperty("lng")
                        val lng: Double?
                    )
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            data class Departure(
                @JsonProperty("place")
                val place: Place?,
                @JsonProperty("time")
                val time: String?
            ) {
                @JsonIgnoreProperties(ignoreUnknown = true)
                data class Place(
                    @JsonProperty("location")
                    val location: Location?,
                    @JsonProperty("originalLocation")
                    val originalLocation: OriginalLocation?,
                    @JsonProperty("type")
                    val type: String?
                ) {
                    @JsonIgnoreProperties(ignoreUnknown = true)
                    data class Location(
                        @JsonProperty("lat")
                        val lat: Double?,
                        @JsonProperty("lng")
                        val lng: Double?
                    )

                    @JsonIgnoreProperties(ignoreUnknown = true)
                    data class OriginalLocation(
                        @JsonProperty("lat")
                        val lat: Double?,
                        @JsonProperty("lng")
                        val lng: Double?
                    )
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            data class Transport(
                @JsonProperty("mode")
                val mode: String?
            )
        }
    }
}