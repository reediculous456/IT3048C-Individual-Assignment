package app.plantdiary.individualassignment3048q.dto

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("Code") val code: String,
    @SerializedName("Name") val name: String
) {
    override fun toString(): String {
        return "$name $code"
    }
}
