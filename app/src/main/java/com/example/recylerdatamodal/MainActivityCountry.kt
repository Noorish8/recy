package com.example.recylerdatamodal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityCountry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var commonAdapterCountry:CommonListAdapter
        val recyclerViewCountry: RecyclerView = findViewById(R.id.activity_main_recylerview)
        val commonCountryData = ArrayList<CommonModel>()
        commonCountryData.add(CommonModel(1, "India"))
        commonCountryData.add(CommonModel(2, "Pakistan"))
        commonCountryData.add(CommonModel(3, "UK"))
        commonCountryData.add(CommonModel(4, "UAE"))
        commonCountryData.add(CommonModel(5, "US"))



        commonAdapterCountry = CommonListAdapter(commonCountryData, false, onclick = { it ->

            Toast.makeText(this@MainActivityCountry, "You Have Selected : ${it.id}", Toast.LENGTH_LONG)
                .show()
            val intent= Intent(this,MainActivityCity::class.java)
            intent.putExtra("country_id", it.id)
            intent.putExtra("country_name", it.name)
            startActivity(intent)
        })


        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerViewCountry.layoutManager = layoutManager
        recyclerViewCountry.adapter = commonAdapterCountry


    }
}