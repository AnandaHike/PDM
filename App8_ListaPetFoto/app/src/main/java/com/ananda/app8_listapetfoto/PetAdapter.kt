package com.ananda.app8_listapetfoto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(var listapet: MutableList<Pet>):RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtDescricao: TextView = view.findViewById(R.id.txtDescricao)
        val txtGenero: TextView = view.findViewById(R.id.txtGenero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.desc_pet, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listapet[position].foto?.let{
            holder.imgFoto.setImageDrawable(it)
        }
        holder.txtNome.text = listapet[position].nome
        holder.txtGenero.text = listapet[position].genero.nome
        holder.txtDescricao.text = listapet[position].descricao

    }

    override fun getItemCount(): Int {
        return listapet.size
    }
}