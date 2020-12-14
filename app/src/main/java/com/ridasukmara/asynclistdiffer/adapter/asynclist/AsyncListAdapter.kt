package com.ridasukmara.asynclistdiffer.adapter.asynclist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ridasukmara.asynclistdiffer.R
import com.ridasukmara.asynclistdiffer.databinding.ItemBinding
import com.ridasukmara.asynclistdiffer.model.User

class AsyncListAdapter: RecyclerView.Adapter<AsyncListAdapter.ViewHolder>() {

    var differ: AsyncListDiffer<User>

    init {
        differ = AsyncListDiffer(this, DiffUtilUserCallback())
    }

    fun submitList(items: List<User>) {
        differ.submitList(items)
    }

    class DiffUtilUserCallback: DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.image == newItem.image
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.image == newItem.image
        }
    }

    class ViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(user: User) {
            binding.user = user
            Glide.with(binding.root.context)
                    .load(user.image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(50,50)
                    .error(R.drawable.broken)
                    .into(binding.imageView)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}
