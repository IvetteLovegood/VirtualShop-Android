package com.ivettehernandez.virtual_shop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by Ivette Hernández on 2019-08-07.
 */
class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        doLogin()
    }

    private fun doLogin(){
        btn_login.setOnClickListener {
            val e = et_email.text.toString().trim()
            val p = et_password.text.toString().trim()
            if(e.isNotEmpty() && p.isNotEmpty()){
                if(p.length > 8){
                   // presenter?.login(e, p, this@LoginActivity)
                }else{
                  //  showToast("Password must be 8 characters or more")
                }
            }else{
               // showToast("Please fill all forms first")
            }
        }

        btn_register.setOnClickListener { startActivity(Intent(this@LoginActivity, RegisterActivity::class.java)) }
    }

}