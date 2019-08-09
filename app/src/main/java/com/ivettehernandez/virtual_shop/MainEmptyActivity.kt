package com.ivettehernandez.virtual_shop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.annotation.Nullable
import com.ivettehernandez.virtual_shop.auth.LoginActivity
import com.ivettehernandez.virtual_shop.utils.Utils

@Suppress("DEPRECATION")
class MainEmptyActivity : AppCompatActivity() {

    internal lateinit var preferences: SharedPreferences

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferences = PreferenceManager.getDefaultSharedPreferences(this@MainEmptyActivity)

        val token_user = preferences.getString("token", "")

        Utils.token = token_user

         val activityIntent: Intent = when {
           !Utils.token.isNullOrEmpty() -> Intent(this, DrawerActivity::class.java)
             else -> Intent(this, LoginActivity::class.java)
        }
        startActivity(activityIntent)
        finish()
    }
}
