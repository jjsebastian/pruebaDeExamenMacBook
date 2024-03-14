package com.utad.colegiodeberes.ui.deberes

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.colegiodeberes.data.network.SchoolApi
import com.utad.colegiodeberes.data.network.model.HomeWorkResponse
import com.utad.colegiodeberes.data.network.storage.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response

class DeberesViewModel: ViewModel() {
        //declarar life data

    private var _userName: MutableLiveData<String> = MutableLiveData(null)
    val userName: LiveData<String?> = _userName

    private var _uiState: MutableLiveData<DeberesUiState> = MutableLiveData(DeberesUiState())
    val uiState:LiveData<DeberesUiState> get() = _uiState

    fun getUserName(context: Context){
        viewModelScope.launch(Dispatchers.IO){
            DataStoreManager.getUserName(context).collect{ userName ->
                if(userName != "No hay datos"){
                    _userName.postValue(userName)
                }

            }


        }

        fun getDeberes(userName : String){
            _uiState.postValue(DeberesUiState(isLoanding = true))

            viewModelScope.launch(Dispatchers.IO) {
                val response: Response<List<HomeWorkResponse>> = SchoolApi.service.getHomeWork(userName, "alonso Quijano")
                if(response.isSuccessful) {
                    _uiState.postValue(DeberesUiState(response = response.body()))
                    } else {
                    _uiState.postValue(DeberesUiState(isError = true))
                    }
            }
        }

    }

}