package com.utad.colegiodeberes.ui.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.colegiodeberes.data.network.storage.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MainViewModel: ViewModel() {

    fun saveUserName(context: Context, username: String){
        viewModelScope.launch(Dispatchers.IO) {
            DataStoreManager.saveUserName(context, username)
        }
    }

}