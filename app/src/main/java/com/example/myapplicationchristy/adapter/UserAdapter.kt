package com.example.myapplicationchristy.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationchristy.model.User

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // Inner class untuk ViewHolder
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Deklarasikan elemen UI di sini dan atur data ke elemen UI jika diperlukan
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
           val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
            return UserViewHolder(itemView)
        }

        // Inflate layout item untuk ViewHolder dan return UserViewHolder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = users[position]
        holder.usernameTextView.text = currentUser.login
        // Bind data lain sesuai kebutuhan
    }

    override fun getItemCount(): Int {
        return users.size
    }

}
