package com.sergio.rafael.jokenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sergio.rafael.jokenpokemon.api.getPokemonApi
import android.support.v7.widget.LinearLayoutManager
import com.sergio.rafael.jokenpokemon.model.Rank
import kotlinx.android.synthetic.main.content_lista.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class RankActivity : AppCompatActivity() {

    private var adapter: RankAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)


        mostrarRank()
    }


    private fun mostrarRank(){
        var retrofit = getPokemonApi().getRank()
        retrofit.enqueue(object : Callback<List<Rank>> {
            override   fun onResponse(call: Call<List<Rank>>, response: Response<List<Rank>>) {
              var ranks = response.body()
                preencherLista(ranks!!)
                Log.i("Rankssss", ": "+response.body())
            }

            override   fun onFailure(call: Call<List<Rank>>, t: Throwable) {

            }
        })
    }

    private fun preencherLista(ranks: List<Rank>){
        rvRanks.layoutManager = LinearLayoutManager(this)
        adapter = RankAdapter(ranks!!)
        rvRanks.adapter = adapter
       // rvRanks.adapter = adapter
     //   rvRanks.layoutManager = LinearLayoutManager(requireContext())
    }
}
