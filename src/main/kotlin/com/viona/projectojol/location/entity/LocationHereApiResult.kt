package com.viona.projectojol.location.entity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class LocationHereApiResult(
    @JsonProperty("items")
    val items: List<Item?>?
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Item(
        @JsonProperty("access")
        val access: List<Acces?>?,
        @JsonProperty("address")
        val address: Address?,
        @JsonProperty("categories")
        val categories: List<Category?>?,
        @JsonProperty("contacts")
        var contacts: List<Contact?>?,
        @JsonProperty("distance")
        val distance: Int?,
        @JsonProperty("id")
        val id: String?,
        @JsonProperty("language")
        val language: String?,
        @JsonProperty("ontologyId")
        val ontologyId: String?,
        @JsonProperty("references")
        var references: List<Reference?>?,
        @JsonProperty("position")
        val position: Position?,
        @JsonProperty("resultType")
        val resultType: String?,
        @JsonProperty("title")
        val title: String?
    ) {
        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Acces(
            @JsonProperty("lat")
            val lat: Double?,
            @JsonProperty("lng")
            val lng: Double?
        )

        @JsonIgnoreProperties(ignoreUnknown = true)
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

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Category(
            @JsonProperty("id")
            val id: String?,
            @JsonProperty("name")
            val name: String?,
            @JsonProperty("primary")
            val primary: Boolean?
        )

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Position(
            @JsonProperty("lat")
            val lat: Double?,
            @JsonProperty("lng")
            val lng: Double?
        )

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Reference(
            @JsonProperty("id")
            var id: String?,
            @JsonProperty("supplier")
            var supplier: Supplier?
        ) {
            @JsonIgnoreProperties(ignoreUnknown = true)
            data class Supplier(
                @JsonProperty("id")
                var id: String?
            )
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Contact(
            @JsonProperty("phone")
            var phone: List<Phone?>?,
            @JsonProperty("www")
            var www: List<Www?>?
        ) {
            @JsonIgnoreProperties(ignoreUnknown = true)
            data class Phone(
                @JsonProperty("value")
                var value: String?
            )

            @JsonIgnoreProperties(ignoreUnknown = true)
            data class Www(
                @JsonProperty("categories")
                var categories: List<Category?>?,
                @JsonProperty("value")
                var value: String?
            ) {
                @JsonIgnoreProperties(ignoreUnknown = true)
                data class Category(
                    @JsonProperty("id")
                    var id: String?
                )
            }
        }
    }
}