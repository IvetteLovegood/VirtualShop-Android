package com.ivettehernandez.virtual_shop

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import com.ivettehernandez.virtual_shop.auth.LoginActivity

class MainEmptyActivity : AppCompatActivity() {


    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val preferences = getSharedPreferences("login", Context.MODE_PRIVATE)

        val token = preferences.getString("token", "")

        Utils.token = token.toString()

        val activityIntent: Intent = when {
            Utils.token != "" -> Intent(this, MainActivity::class.java)
        else -> Intent(this, LoginActivity::class.java)
        }
        startActivity(activityIntent)
        finish()
    }
}
