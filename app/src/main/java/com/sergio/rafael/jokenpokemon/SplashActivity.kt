package com.sergio.rafael.jokenpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val SPLASHSCREEN = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        showSplash()
    }

    private fun showLoginScreen(){
        val nextScreen = Intent(this, LoginActivity::class.java)
        startActivity(nextScreen)
        finish()
    }

    private fun showSplash(){
        val anim = AnimationUtils.loadAnimation(this, R.anim.animation_splash)
        anim.reset()
        ivScreen.clearAnimation()
        ivScreen.startAnimation(anim)

        Handler().postDelayed({
            showLoginScreen()
        }, SPLASHSCREEN)
    }
}
