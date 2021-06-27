package com.norbertto.exemploretrofit

/**
 * Nesta classe estamos criando configurações para o retrofit conseguir
 * se comunicar e saber como ele se comporta
 * **/

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton - (private constructor) 1 instância
class RetrofitClient private constructor(){
    companion object{
        private lateinit var retrofit: Retrofit
        /** OBS-1 **/
        private val baseUrl = "https://jsonplaceholder.typicode.com/"

        private fun getRetrofitInstance(): Retrofit{
            /** OBS-2 **/
            val httpClient = OkHttpClient.Builder()
            if(!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        //AQUI INFORMO A FUNÇÃO QUE ELA RECEBE E RETORNA UM TIPO GERENICO
        fun <S> createService(serviceClass: Class<S>): S{
            return getRetrofitInstance().create(serviceClass)
        }
    }
}

/** OBS-1
 * Na URL o retrofit espera uma / no final do endereço, para não dar erro
 * **/

/** OBS-2
 * A classe OkHttpCleint já é dentro do android que gerencia as comunicações http
 * é ele que vai conseguir conectar a internet
 * **/