package com.example.displayapp

data class DataClassPost(
    val postId : Int,
    val id: Int,
    val name : String,
    val email : String,
    val body : String,
    val post : Post
)

data class Post(
    val get : List<DataClassPost>
)
