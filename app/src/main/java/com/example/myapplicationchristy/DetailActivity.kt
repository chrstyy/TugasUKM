package com.example.myapplicationchristy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationchristy.api.GitHubApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplicationchristy.util.DarkModeManager


class DetailActivity : AppCompatActivity() {

    private lateinit var avatarImageView: ImageView
    private lateinit var usernameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        avatarImageView = findViewById(R.id.avatarImageView)
        usernameTextView = findViewById(R.id.usernameTextView)

        val username = intent.getStringExtra("username")
        if (username != null) {
            val apiService = RetrofitClient.createService(GitHubApiService::class.java)
            CoroutineScope(Dispatchers.Main).launch {
                val response = apiService.getUserDetails(username)
                if (response.isSuccessful) {
                    val userDetail = response.body()
                    if (userDetail != null) {
                        // Tampilkan informasi detail pengguna di layout
                        Glide.with(this@DetailActivity)
                            .load(userDetail.avatar_url)
                            .placeholder(R.drawable.ic_avatar_placeholder)
                            .into(avatarImageView)
                        usernameTextView.text = userDetail.login
                    }
                } else {
                    // Handle error
                }
            }
        }
    }
}
