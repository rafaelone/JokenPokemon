package com.sergio.rafael.jokenpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Callback
import android.util.Log
import android.widget.Toast
import com.sergio.rafael.jokenpokemon.api.getPokemonApi
import com.sergio.rafael.jokenpokemon.model.Rank
import kotlinx.android.synthetic.main.activity_game_over.*
import retrofit2.Call
import retrofit2.Response


class GameOverActivity : AppCompatActivity() {

    lateinit var rank: Rank

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        btnMenu.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        if(intent.extras == null){
            showPlay()
        }else{
            registrarPontuacaoJogador()
        }
    }

    private fun showPlay(){
        var showPlay = Intent(this, JogarActivity::class.java)
        startActivity(showPlay)
        finish()
    }

    private fun registrarPontuacaoJogador(){


        btnNovamente.setOnClickListener {
            val pontos = intent.extras.getInt("PONTUACAO", 0)
            val nome = etNomeOver.text
            val rank = Rank( nome.toString(), pontos.toString())
            Log.i("testando" , ": "+rank)

            if(nome.length < 3){

                Toast.makeText(this, "Informe um nome correto", Toast.LENGTH_SHORT).show()
            }
            else{
                var retrofit = getPokemonApi()
               retrofit.registerRank(rank).enqueue(object: Callback<Void>{
                   override fun onFailure(call: Call<Void>, t: Throwable) {
                       Toast.makeText(this@GameOverActivity, "Erro: " +t, Toast.LENGTH_LONG).show()
                       Throwable(t)
                   }

                   override fun onResponse(call: Call<Void>, response: Response<Void>) {
                       Toast.makeText(this@GameOverActivity, "Cadastro", Toast.LENGTH_LONG).show()
                       showPlay()
                   }


               })
            }
        }

    }


}


