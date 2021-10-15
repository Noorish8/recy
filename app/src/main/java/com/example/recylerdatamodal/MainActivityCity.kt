package com.example.recylerdatamodal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityCity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var commonAdapterCity:CommonListAdapter
        val recyclerViewCountry: RecyclerView = findViewById(R.id.activity_main_recylerview)
        val commonCityData = ArrayList<CommonModel>()
        commonCityData.add(CommonModel(1, "Ahmedabad", 1))
        commonCityData.add(CommonModel(2, "New Delhi", 1))
        commonCityData.add(CommonModel(3, "Goa", 1))
        commonCityData.add(CommonModel(4, "karachi", 2))
        commonCityData.add(CommonModel(5, "London",3))
        commonCityData.add(CommonModel(6, "san francisco",5))
        commonCityData.add(CommonModel(7, "Dubai",4))
        commonCityData.add(CommonModel(8, "sharjah",4))

        val countryId= intent.getIntExtra("country_id",0);
        val filteredList = commonCityData.filter { city -> city.countryId==countryId };

        commonAdapterCity = CommonListAdapter(filteredList, true, onclick = { it ->

            Toast.makeText(this@MainActivityCity, "You Have Selected : ${it.id}", Toast.LENGTH_LONG)
                .show()
//            val intent= Intent(this,City::class.java)
//            intent.putExtra("country_id", it.id)
//            intent.putExtra("country_name", it.name)
//            startActivity(intent)
        })


        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerViewCountry.layoutManager = layoutManager
        recyclerViewCountry.adapter = commonAdapterCity


    }
}