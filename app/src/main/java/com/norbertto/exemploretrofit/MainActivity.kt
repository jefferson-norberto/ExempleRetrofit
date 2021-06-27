package com.norbertto.exemploretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remote = RetrofitClient.createService(PostService::class.java)
        val call: Call<List<PostModel>> = remote.list()

        val response = call.enqueue(object : Callback<List<PostModel>>{
            override fun onResponse( call: Call<List<PostModel>>, res: Response<List<PostModel>> ) {
                val s = res.body()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val s = t.message
            }

        })
    }
}