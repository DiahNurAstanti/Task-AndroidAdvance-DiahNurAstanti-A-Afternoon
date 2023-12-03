package com.example.projectandroidadvanced

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projectandroidadvanced.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        sharedPreferences = requireContext().getSharedPreferences("Data Nama", Context.MODE_PRIVATE)
        binding.btnSimpan.setOnClickListener(this)
        binding.btnTampil.setOnClickListener(this)


        return binding.root
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_simpan -> {
                val nama = binding.inputnama.text.toString()
                val edit = sharedPreferences.edit()
                edit.putString("nama", nama)
                edit.apply()
                Toast.makeText(
                    activity,
                    "Data Nama disimpan dengan sharePreferences",
                    Toast.LENGTH_SHORT
                ).show()
            }

            R.id.btn_tampil -> {
                val namatampil = sharedPreferences.getString("nama", "")
                binding.tvTampilnama.text = "nama anda: $namatampil"
            }
        }
    }
}