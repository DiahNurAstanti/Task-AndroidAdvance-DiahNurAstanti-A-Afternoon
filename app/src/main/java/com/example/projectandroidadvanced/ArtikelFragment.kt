package com.example.projectandroidadvanced

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectandroidadvanced.databinding.FragmentArtikelBinding

class ArtikelFragment : Fragment() {
    private lateinit var binding: FragmentArtikelBinding
    private lateinit var adapterArtikel: ArtikelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArtikelBinding.inflate(inflater, container, false)
        binding.rvArtikel.layoutManager = LinearLayoutManager(activity)
        setArtikelAdapter()
        return binding.root
    }

    private fun setArtikelAdapter() {
        val dataList: MutableList<ArtikelModel> = mutableListOf()

        judulArtikel().forEachIndexed { index, judul ->
            dataList.add(
                ArtikelModel(judul)
            )
        }

        adapterArtikel = ArtikelAdapter(context, dataList)
        binding.rvArtikel.adapter = adapterArtikel
    }

    private fun judulArtikel(): Array<String> {
        return resources.getStringArray(R.array.judulArtikel)
    }
}