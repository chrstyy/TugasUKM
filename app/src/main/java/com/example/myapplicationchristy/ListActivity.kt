package com.example.myapplicationchristy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById(R.id.recyclerView)

        val apiService = RetrofitClient.createService(GitHubApiService::class.java)
        // Panggil API untuk mendapatkan daftar pengguna
        CoroutineScope(Dispatchers.Main).launch {
            val response = apiService.searchUsers("your_query_here")
            if (response.isSuccessful) {
                val users = response.body()?.items ?: emptyList()
                userAdapter = UserAdapter(users)
                recyclerView.adapter = userAdapter
            } else {
                // Handle error
            }
        }
    }
}
