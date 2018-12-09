package com.sergio.rafael.jokenpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_jogar.*
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class JogarActivity : AppCompatActivity() {

    val FOGO = 1
    val AGUA = 2
    val PLANTA = 3
    var rodada = 0
    var pontuacaoJogador = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogar)


        jogador()
    }

    private fun jogador(){
        ivChar.setOnClickListener {
            ivVoce.setImageResource(R.drawable.charmander)
            sortearImagem(FOGO)
        }

        ivSqui.setOnClickListener {
            ivVoce.setImageResource(R.drawable.squirtle)
            sortearImagem(AGUA)
        }

        ivBulba.setOnClickListener {
          ivVoce.setImageResource(R.drawable.bulbasaur)
            sortearImagem(PLANTA)
        }


    }

    private fun sortearImagem(jogador: Int){
        var aleatorio = Random()
        var jogadaPc = aleatorio.nextInt(3)+1
        Log.i("sorteio pc: " ,"" +jogadaPc)

        when(jogadaPc){
            FOGO->{

                ivComputador.setImageResource(R.drawable.charmander)
                when(jogador){
                    FOGO->{
                        empate()
                    }
                    AGUA->{
                        vitoria()
                    }
                    PLANTA->{
                        derrota()
                    }
                }
            }
            AGUA->{
                ivComputador.setImageResource(R.drawable.squirtle)
                when(jogador){
                    FOGO->{
                       derrota()
                    }
                    AGUA->{
                        empate()
                    }
                    PLANTA->{
                       vitoria()
                    }
                }
            }
            PLANTA->{
                ivComputador.setImageResource(R.drawable.bulbasaur)
                when(jogador){
                    FOGO->{
                        vitoria()
                    }
                    AGUA->{
                        derrota()
                    }
                    PLANTA->{
                        empate()
                    }
                }
            }
        }


    }

    private fun vitoria(){
        etResultado.text = "Você ganhou"
        var soma = resultUsuario.text.toString().toInt() +2
        resultUsuario.text = soma.toString()
        rodada = rodada +1
        pontuacaoJogador = soma
        Log.i("rodada", ": "+ rodada)
        if(rodada > 10){
            gameOver()
        }
    }

    private fun derrota(){
        etResultado.text = "Você perdeu"
        var soma = resultPc.text.toString().toInt() + 2
        resultPc.text = soma.toString()
        rodada = rodada +1
        if(rodada > 10){
            gameOver()
        }

    }

    private fun empate(){
        etResultado.text = "Empatou"
        rodada = rodada +1
        if(rodada > 10){
            gameOver()
        }

    }

    private fun gameOver(){
       var intent = Intent(this, GameOverActivity::class.java)
        intent.putExtra("PONTUACAO", pontuacaoJogador)
        startActivity(intent)
        finish()
    }


}
