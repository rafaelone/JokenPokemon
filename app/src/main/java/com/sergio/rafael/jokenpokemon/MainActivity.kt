package com.sergio.rafael.jokenpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJogar.setOnClickListener {
            showPlay()
        }

        btnRank.setOnClickListener {
            showRank()
        }

        btnSair.setOnClickListener{
            mAuth = FirebaseAuth.getInstance()
            mAuth.signOut()
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnSobre.setOnClickListener {
            showSobre()
        }
    }


    private fun showPlay(){
        val intent = Intent(this, JogarActivity::class.java)
        startActivity(intent)
    }

    private fun showRank(){
        val intent = Intent(this, RankActivity::class.java)
        startActivity(intent)
    }

    private fun showSobre(){
        val intent = Intent(this, SobreActivity::class.java)
        startActivity(intent)
    }

}
