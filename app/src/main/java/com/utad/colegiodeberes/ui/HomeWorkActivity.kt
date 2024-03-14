package com.utad.colegiodeberes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.colegiodeberes.R
import com.utad.colegiodeberes.databinding.ActivityHomeWorkBinding
import com.utad.colegiodeberes.ui.adapter.DeberesAdapter
import com.utad.colegiodeberes.ui.deberes.DeberesViewModel

class HomeWorkActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityHomeWorkBinding
    private val binding: ActivityHomeWorkBinding get() =_binding

    private val viewModel: DeberesViewModel by viewModels()


    private val adapter: DeberesAdapter = DeberesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDeberes.layoutManager = LinearLayoutManager(this)
        binding.rvDeberes.adapter = adapter

        viewModel.getUserName(this)

        observerViewModel()

    }

    private fun observerViewModel() {
        viewModel.userName.observe(this){ userName ->
            if(userName != null){
                //TODO llamamos a la api

            }

        }
    }
}