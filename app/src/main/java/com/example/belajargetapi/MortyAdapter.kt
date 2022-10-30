package com.example.belajargetapi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belajargetapi.databinding.ItemRawMortyBinding

class MortyAdapter(val dataMorty: List<ResultsItem?>?) :
    RecyclerView.Adapter<MortyAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: ItemRawMortyBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemRawMortyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataMorty?.get(position)
        holder.binding.apply {
            itemNameMorty.text = data?.name
            status.text = data?.status
            itemSpeciesMorty.text = data?.species

            Glide.with(itemImageMorty)
                .load(data?.image)
                .error(R.drawable.ic_launcher_background)
                .into(itemImageMorty)
        }

        holder.itemView.setOnClickListener {
            val name = data?.name
            Toast.makeText(holder.itemView.context, "$name", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        if (dataMorty != null) {
            return dataMorty.size
        }
        return 0
    }
}