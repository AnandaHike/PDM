package com.ananda.app9_tarefastexto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TarefaAdapter(var listaTerefas: MutableList<Tarefas>):RecyclerView.Adapter<TarefaAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtDescricao: TextView = view.findViewById(R.id.txtDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaTerefas[position].foto?.let{
            holder.imgFoto.setImageDrawable(it)
        }
        holder.txtDescricao.text = listaTerefas[position].descricao
    }

    override fun getItemCount(): Int {
        return listaTerefas.size
    }
}