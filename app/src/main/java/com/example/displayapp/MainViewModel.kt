package com.example.displayapp.com.example.displayapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.displayapp.APIService
import com.example.displayapp.DataClassPost
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _postState = mutableStateOf(PostState())
    val postState: State<PostState> = _postState

    init {
        fetchPost()
    }

    fun fetchPost() {
        viewModelScope.launch {
            try {
                val response = APIService.getpost()
                _postState.value = PostState(
                    loading = false,
                    list = response,
                    error = null
                )
            } catch (e: Exception) {
                _postState.value = _postState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )
            }
        }

    }

    data class PostState(
        val loading: Boolean = true,
        val list: List<DataClassPost> = emptyList(),
        val error: String? = null
    )
}
