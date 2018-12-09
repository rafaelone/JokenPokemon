package com.sergio.rafael.jokenpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJogar.setOnClickListener {
            showPlay()
        }

        btnRank.setOnClickListener {
            showRank()
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
}
