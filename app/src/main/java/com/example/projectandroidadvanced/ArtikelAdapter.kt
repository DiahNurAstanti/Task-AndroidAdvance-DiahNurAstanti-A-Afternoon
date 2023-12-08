package com.example.projectandroidadvanced

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectandroidadvanced.databinding.ListArtikelBinding


class ArtikelAdapter(private val context: Context?, private val list: MutableList<CommentItem>) :
    RecyclerView.Adapter<ArtikelAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListArtikelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.judulArtikel.text = this.email
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun setData(data: Comment) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
        }

}