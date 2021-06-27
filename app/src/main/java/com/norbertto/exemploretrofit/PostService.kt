package com.norbertto.exemploretrofit

import retrofit2.Call
import retrofit2.http.GET

/**
 * O nome dessa classe é de acordo com o recurso que estou buscando
 * na API, se fosse por exemplo o comments no lugar do post o nome
 * seria CommentsService
 * **/


interface PostService {

    //O nome dessa função é você quem define
    @GET("posts")
    fun list(): Call<List<PostModel>>

}