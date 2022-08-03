package com.viona.projectojol.location


import com.fasterxml.jackson.annotation.JsonProperty

data class LocationSearchResult(
    @JsonProperty("items")
    val items: List<Item?>?
) {
    data class Item(
        @JsonProperty("access")
        val access: List<Acces?>?,
        @JsonProperty("address")
        val address: Address?,
        @JsonProperty("categories")
        val categories: List<Category?>?,
        @JsonProperty("distance")
        val distance: Int?,
        @JsonProperty("id")
        val id: String?,
        @JsonProperty("language")
        val language: String?,
        @JsonProperty("ontologyId")
        val ontologyId: String?,
        @JsonProperty("position")
        val position: Position?,
        @JsonProperty("resultType")
        val resultType: String?,
        @JsonProperty("title")
        val title: String?
    ) {
        data class Acces(
            @JsonProperty("lat")
            val lat: Double?,
            @JsonProperty("lng")
            val lng: Double?
        )

        data class Address(
            @JsonProperty("city")
            val city: String?,
            @JsonProperty("countryCode")
            val countryCode: String?,
            @JsonProperty("countryName")
            val countryName: String?,
            @JsonProperty("county")
            val county: String?,
            @JsonProperty("district")
            val district: String?,
            @JsonProperty("houseNumber")
            val houseNumber: String?,
            @JsonProperty("label")
            val label: String?,
            @JsonProperty("postalCode")
            val postalCode: String?,
            @JsonProperty("street")
            val street: String?,
            @JsonProperty("subdistrict")
            val subdistrict: String?
        )

        data class Category(
            @JsonProperty("id")
            val id: String?,
            @JsonProperty("name")
            val name: String?,
            @JsonProperty("primary")
            val primary: Boolean?
        )

        data class Position(
            @JsonProperty("lat")
            val lat: Double?,
            @JsonProperty("lng")
            val lng: Double?
        )
    }
}