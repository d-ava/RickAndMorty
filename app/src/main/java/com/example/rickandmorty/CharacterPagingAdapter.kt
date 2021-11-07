package com.example.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemBinding
import com.example.rickandmorty.extensions.glideExtension
import com.example.rickandmorty.model.RickAndMorty

//typealias OnImageClick = (item: RickAndMorty.Character) -> Unit

class CharacterPagingAdapter :
    PagingDataAdapter<RickAndMorty.Character, CharacterPagingAdapter.ViewHolder>(DiffCallBack()) {

   // lateinit var onImageClick: OnImageClick

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun onBind(character: RickAndMorty.Character) {

            binding.tvName.text = character.name
            binding.ivAvatar.glideExtension(character.image)

        }



    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    class DiffCallBack : DiffUtil.ItemCallback<RickAndMorty.Character>() {
        override fun areItemsTheSame(
            oldItem: RickAndMorty.Character,
            newItem: RickAndMorty.Character
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: RickAndMorty.Character,
            newItem: RickAndMorty.Character
        ) = oldItem == newItem
    }

}