package com.example.recylerdatamodal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommonListAdapter(val list: List<CommonModel>, val isCity: Boolean, val onclick: (CommonModel) -> Unit) :
    RecyclerView.Adapter<CommonListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtName: TextView = itemView.findViewById(R.id.row_common_list_txt_id)
        val txtId: TextView = itemView.findViewById(R.id.row_common_list_txt_name)
        val countryId: TextView = itemView.findViewById(R.id.row_common_list_txt_country_id)

        init {
            itemView.setOnClickListener {
                onclick(list[layoutPosition])
            }
        }

        fun bind(commonModel: CommonModel) {
            txtName.text = commonModel.name
            txtId.text = commonModel.id.toString()
            if(isCity){
                countryId.visibility= View.VISIBLE
                countryId.text = commonModel.countryId.toString()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_common_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
