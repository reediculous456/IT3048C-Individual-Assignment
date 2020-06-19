package app.plantdiary.individualassignment3048q.ui.main

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import app.plantdiary.individualassignment3048q.R
import app.plantdiary.individualassignment3048q.dto.Country

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private lateinit var mMap: GoogleMap
    private var mapReady = false
    private lateinit var viewModel: MainViewModel
    private lateinit var countries: List<Country>

    private val callback = OnMapReadyCallback { googleMap ->
        mMap = googleMap
        mapReady = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.maps_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.countries.observe(this, Observer {
            countries -> this.countries = countries
            updateMap()
        })
    }

    private fun updateMap() {
        if (mapReady && countries != null) {
            countries.forEach { country ->
                val sydney = LatLng(-34.0, 151.0)
                mMap.addMarker(MarkerOptions().position(sydney).title(country.toString()))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            }
        }
    }
}