package com.utad.colegiodeberes.ui.deberes

import com.utad.colegiodeberes.data.network.model.HomeWorkResponse

data class DeberesUiState(
    val isLoanding: Boolean = false,
    val isError:Boolean = false,
    val response: List<HomeWorkResponse>? = null

)
