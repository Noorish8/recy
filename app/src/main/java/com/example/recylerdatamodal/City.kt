package com.example.recylerdatamodal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class City : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
//        val countryId = intent.getStringExtra("country_id")
//        val countryName = intent.getStringExtra("country_name")
        val adapter:CityListAdapter
        val recyclerViewCountry: RecyclerView = findViewById(R.id.activity_main_recylerview)

        val cityData = ArrayList<CityModel>()
        cityData.add(CityModel(1, 1, "Ahmedabad"))
        cityData.add(CityModel(2, 1, "Ahmedabad"))
        cityData.add(CityModel(3, 1, "Ahmedabad"))
        cityData.add(CityModel(4, 1, "Ahmedabad"))
        cityData.add(CityModel(5, 1, "Ahmedabad"))


        adapter = CityListAdapter(cityData.filter { city -> city.countryId==intent.getIntExtra("country_id",0) }, onclick = { it ->

            //val data: String? =intent.getStringExtra("id")
            //Toast.makeText(this, "You Have Selected : ${it.cityId}", Toast.LENGTH_LONG).show()
//             val sentIntent:Intent=Intent()
//             intent.getStringExtra("samplename").toString()
//             intent.getStringExtra("samplename").toString()
//             startActivity(intent)

        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerViewCountry.layoutManager = layoutManager
        recyclerViewCountry.adapter = adapter
    }
}