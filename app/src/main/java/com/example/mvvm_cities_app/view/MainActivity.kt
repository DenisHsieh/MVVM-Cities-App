package com.example.mvvm_cities_app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_cities_app.databinding.ActivityMainBinding
import com.example.mvvm_cities_app.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {
//    private val viewModel: CityViewModel by viewModels()
    private lateinit var viewModel: CityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        viewModel.getCityData().observe(this) { city ->
            binding.cityImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme)
            )

            binding.cityNameTV.text = city.name
            binding.cityPopulationTV.text = city.population.toString()
        }
    }
}