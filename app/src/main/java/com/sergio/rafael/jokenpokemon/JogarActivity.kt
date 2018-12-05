package com.sergio.rafael.jokenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_jogar.*
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class JogarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogar)

        jogador()
    }

    private fun jogador(){
        ivBulba.setOnClickListener {
          ivVoce.setImageResource(R.drawable.bulbasaur)
            shorImage()
        }
        ivChar.setOnClickListener {
            ivVoce.setImageResource(R.drawable.charmander)
            shorImage()
        }
        ivSqui.setOnClickListener {
            ivVoce.setImageResource(R.drawable.squirtle)
            shorImage()
        }

    }

    private fun shorImage(){
       var images = arrayOf(R.drawable.bulbasaur, R.drawable.charmander, R.drawable.squirtle)
        var r = Random()
        var n = r.nextInt(3)
        val Escolhacharmander = ivVoce.resources.getResourceEntryName(R.drawable.charmander)
        val Escolhabulba = ivVoce.resources.getResourceEntryName(R.drawable.bulbasaur)
        val Escolhasquirtle = ivVoce.resources.getResourceEntryName(R.drawable.squirtle)

        when(images[n]) {

            R.drawable.bulbasaur -> {
                if(Escolhacharmander == "charmander"){
                    resultuUsuario.text.toString().toInt() +1
                    etResultado.text = "Voce ganhou"
                }else if (Escolhabulba == "bulbasaur"){
                    etResultado.text = "Empate"
                }

            }

            R.drawable.squirtle -> {}
            R.drawable.charmander -> {}
        }
        ivComputador.setImageResource(images[n])

    }
}
