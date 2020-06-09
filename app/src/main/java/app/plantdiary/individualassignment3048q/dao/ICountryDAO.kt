package app.plantdiary.individualassignment3048q.dao

import app.plantdiary.individualassignment3048q.dto.Country
import retrofit2.Call
import retrofit2.http.GET

interface ICountryDAO {
    @GET("country-list/r/data.json")
    fun getAllCountries(): Call<ArrayList<Country>>
}