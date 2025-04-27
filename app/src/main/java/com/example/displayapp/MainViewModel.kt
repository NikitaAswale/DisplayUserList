//package com.example.displayapp
//
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.launch
//
//class MainViewModel {
//    package com.example.sampleuserlist
//    import androidx.compose.runtime.State
//    import androidx.compose.runtime.mutableStateOf
//    import androidx.lifecycle.ViewModel
//    import androidx.lifecycle.viewModelScope
//    import kotlinx.coroutines.launch
//
//    class MainViewModel : ViewModel() {
//
//        private val _postState = mutableStateOf(PostState())
//        val postState : State<PostState> = _postState
//
//        private val _userState = mutableStateOf(UserState())
//        val userState : State<UserState> = _userState
//
//        init {
//            fetchPost()
//            fetchUser()
//        }
//
//        fun fetchPost(){
//            viewModelScope.launch{
//                try{
//                    val response = ApiService.getPost()
//                    _postState.value = PostState(
//                        loading = false,
//                        list = response,
//                        error = null
//                    )
//                }catch (e : Exception){
//                    _postState.value =_postState.value.copy(
//                        loading = false,
//                        error = "Error fetching categories ${e.message}"
//                    )
//                }
//            }
//
//        }
//
//        fun fetchUser(){
//            viewModelScope.launch{
//                try{
//                    val response = ApiService.getUser()
//                    _userState.value = UserState(
//                        loading = false,
//                        list = response,
//                        error = null
//                    )
//                }catch (e : Exception){
//                    _userState.value =_userState.value.copy(
//                        loading = false,
//                        error = "Error fetching categories ${e.message}"
//                    )
//                }
//            }
//
//        }
//
//
//        data class PostState(
//            val loading: Boolean = true,
//            val list: List<Post> = emptyList(),
//            val error: String? = null
//        )
//
//        data class UserState(
//            val loading: Boolean = true,
//            val list: List<User> = emptyList(),
//            val error: String? = null
//        )
//
//    }
//}