package com.viona.projectojol.location

data class Location(
    var name: String = "",
    var address: Address? = null,
    var coordinate: Coordinate? = null
) {
    data class Address(
        var city: String = "",
        var country: String = "",
        var distric: String = ""
    )
}