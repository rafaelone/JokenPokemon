package com.sergio.rafael.jokenpokemon

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sergio.rafael.jokenpokemon.model.Rank

class RankAdapter( var ranks: List<Rank>): RecyclerView.Adapter<RankAdapter.RankViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankAdapter.RankViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rank_item, parent, false)
        return RankViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ranks.size
    }

    override fun onBindViewHolder(holder: RankAdapter.RankViewHolder, position: Int) {
        val rank = ranks[position]
        holder.tvNomeJogador.text = rank.nome
        holder.tvPontuacao.text = rank.pontos

    }

    class RankViewHolder(v: View): RecyclerView.ViewHolder(v){
        var tvNomeJogador: TextView = v.findViewById(R.id.tvNomeJogador)
        var tvPontuacao: TextView = v.findViewById(R.id.tvPontuacao)
    }

}