package app.plantdiary.individualassignment3048q.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.plantdiary.individualassignment3048q.dto.Country
import app.plantdiary.individualassignment3048q.service.CountryService

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var countries: MutableLiveData<ArrayList<Country>> = MutableLiveData<ArrayList<Country>>()
    private val countryService: CountryService = CountryService()

    init {
        fetchCountries()
    }

    fun fetchCountries(): Unit {
        countries = countryService.fetchCountries()
    }
}
