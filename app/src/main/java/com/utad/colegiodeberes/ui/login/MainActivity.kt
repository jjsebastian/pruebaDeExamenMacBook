package com.utad.colegiodeberes.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.utad.colegiodeberes.R
import com.utad.colegiodeberes.data.network.model.HomeWorkResponse
import com.utad.colegiodeberes.databinding.ActivityMainBinding
import com.utad.colegiodeberes.ui.HomeWorkActivity
import java.nio.file.AccessMode

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding: ActivityMainBinding get() = _binding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAcceso.setOnClickListener{
             saveUser()

        }

    }

    private fun saveUser() {
        val name = binding.etUsuario.text.toString().trim()
        if(!name.isNullOrEmpty()){
            viewModel.saveUserName(this,name)
            goToHomeWorkScreen()
            }else{
                Toast.makeText(this,"introduce texto",Toast.LENGTH_LONG).show()
        }
    }

    private fun goToHomeWorkScreen() {
        val intent = Intent(this,HomeWorkActivity::class.java)
        finish()
    }
}