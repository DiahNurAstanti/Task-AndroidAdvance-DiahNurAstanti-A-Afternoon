package com.example.projectandroidadvanced

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectandroidadvanced.databinding.FragmentArtikelBinding

class ArtikelFragment : Fragment() {
    private lateinit var binding: FragmentArtikelBinding
    private lateinit var adapterArtikel: ArtikelAdapter
    private lateinit var viewModel: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArtikelBinding.inflate(inflater, container, false)
        binding.rvArtikel.layoutManager = LinearLayoutManager(activity)
        adapterArtikel = ArtikelAdapter(requireContext(), arrayListOf())
        adapterArtikel.notifyDataSetChanged()
        val repository = PostRepository()
        val viewModelFactory = PostViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        setArtikelAdapter()
        return binding.root
    }

    private fun setArtikelAdapter() {
        viewModel.getComment()
        viewModel.comment.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                adapterArtikel.setData(response.body()!!)
                binding.rvArtikel.adapter = adapterArtikel
                }
            })

    }


//    private fun setArtikelAdapter() {
//        val dataList: MutableList<ArtikelModel> = mutableListOf()
//
//        judulArtikel().forEachIndexed { index, judul ->
//            dataList.add(
//                ArtikelModel(judul)
//            )
//        }
//
//        adapterArtikel = ArtikelAdapter(context, dataList)
//        binding.rvArtikel.adapter = adapterArtikel
//    }

//    private fun judulArtikel(): Array<String> {
//        return resources.getStringArray(R.array.judulArtikel)
//    }
}