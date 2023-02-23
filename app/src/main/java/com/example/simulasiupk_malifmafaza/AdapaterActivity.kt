package com.example.simulasiupk_malifmafaza

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapaterActivity(private val dataset: ArrayList<DataUPK>)
    : RecyclerView.Adapter<AdapaterActivity.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val panjang = view.findViewById<TextView>(R.id.panjang)
        val lebar = view.findViewById<TextView>(R.id.lebar)
        val keliling = view.findViewById<TextView>(R.id.keliling)
        val hasil = view.findViewById<TextView>(R.id.hasil)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_adapater,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataset[position]
        holder.panjang.text = data.panjang
        holder.lebar.text = data.lebar
        holder.keliling.text = data.rb
        holder.hasil.text = data.hasil
    }

    override fun getItemCount(): Int = dataset.size
}