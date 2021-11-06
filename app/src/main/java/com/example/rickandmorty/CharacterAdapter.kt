package com.example.rickandmorty

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import com.example.rickandmorty.databinding.ItemBinding
import com.example.rickandmorty.extensions.glideExtension
import com.example.rickandmorty.model.RickAndMorty


class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private val list: MutableList<RickAndMorty.Character> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(all: RickAndMorty) {


        this.list.clear()
        this.list.addAll(all.results)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = list.size


    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var charactersData: RickAndMorty.Character
        fun onBind() {
            charactersData = list[adapterPosition]
            binding.tvName.text = charactersData.name.toString()
            binding.ivAvatar.glideExtension(charactersData.image)


            /*  binding.apply {
                  this.tvGender.text = charactersData.gender
                  this.tvName.text = charactersData.name
              }*/


        }

    }
}