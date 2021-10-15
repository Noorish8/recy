package com.example.recylerdatamodal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityListAdapter(val list: List<CityModel>, val onclick: (CityModel) -> Unit) :
    RecyclerView.Adapter<CityListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtCountryName: TextView = itemView.findViewById(R.id.row_country_list_txt_name)
        val txtCountyId: TextView = itemView.findViewById(R.id.row_country_list_txt_id)

        init {
            itemView.setOnClickListener {
                onclick(list[layoutPosition])
            }
        }

        fun bind(cityModel: CityModel) {
            txtCountryName.text = cityModel.cityName
            txtCountyId.text = cityModel.cityId.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_country_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
