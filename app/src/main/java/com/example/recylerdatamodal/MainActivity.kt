package com.example.recylerdatamodal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapterCountry:CountryListAdapter
        val recyclerViewCountry: RecyclerView = findViewById(R.id.activity_main_recylerview)
        val countryData = ArrayList<CountryModal>()
        countryData.add(CountryModal(1, "India"))
        countryData.add(CountryModal(2, "Pakistan"))
        countryData.add(CountryModal(3, "UK"))
        countryData.add(CountryModal(4, "UAE"))
        countryData.add(CountryModal(5, "US"))



        adapterCountry = CountryListAdapter(countryData, onclick = { it ->

            Toast.makeText(this@MainActivity, "You Have Selected : ${it.id}", Toast.LENGTH_LONG)
                .show()
            val intent= Intent(this,City::class.java)
            intent.putExtra("country_id", it.id)
            intent.putExtra("country_name", it.name)
            startActivity(intent)

/*
            val intent = Intent(this@MainActivity, Citys::class.java)
            startActivity(intent)*/
        })


        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerViewCountry.layoutManager = layoutManager
        recyclerViewCountry.adapter = adapterCountry


    }
}