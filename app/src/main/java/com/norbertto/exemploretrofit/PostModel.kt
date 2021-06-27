package com.norbertto.exemploretrofit

import com.google.gson.annotations.SerializedName

/**
 * Aqui é a entidade, nela eu mapeio as váriaveis do meu recurso
 * **/

class PostModel  {
    //da classe gson, para converter o gson para a varável
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("userId")
    var userID: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("body")
    var body: String = ""

}