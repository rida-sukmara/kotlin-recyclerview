package com.ridasukmara.asynclistdiffer.adapter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ridasukmara.asynclistdiffer.R
import com.ridasukmara.asynclistdiffer.databinding.ItemBinding
import com.ridasukmara.asynclistdiffer.model.User

class RecyclerViewAdapter(var items: List<User>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(user: User) {
            binding.user = user

            Glide.with(binding.root.context)
                    .load(user.image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(50, 50)
                    .error(R.drawable.broken)
                    .into(binding.imageView)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
