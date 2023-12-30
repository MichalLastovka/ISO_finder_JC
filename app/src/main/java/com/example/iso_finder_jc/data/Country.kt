package com.example.iso_finder_jc.data


import com.google.gson.annotations.SerializedName

class Country(
    @SerializedName("alpha-2")
    val alpha2: String,
    @SerializedName("alpha-3")
    val alpha3: String,
    @SerializedName("country-code")
    val countryCode: String,
    @SerializedName("intermediate-region")
    val intermediateRegion: String,
    @SerializedName("intermediate-region-code")
    val intermediateRegionCode: String,
    @SerializedName("iso_3166-2")
    val iso31662: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("region-code")
    val regionCode: String,
    @SerializedName("sub-region")
    val subRegion: String,
    @SerializedName("sub-region-code")
    val subRegionCode: String
)