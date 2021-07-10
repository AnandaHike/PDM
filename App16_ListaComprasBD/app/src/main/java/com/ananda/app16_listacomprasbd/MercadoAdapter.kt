package com.ananda.app16_listacomprasbd


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class MercadoAdapter (var listaMercado: List<Mercado>, var listener: MercadoAdapterListener):RecyclerView.Adapter<MercadoAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtMercado: TextView = view.findViewById(R.id.txtMercado)
        val btnExcluir: ImageButton = view.findViewById(R.id.btnExcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mercado, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.txtMercado.text = listaMercado[position].nome

        holder.btnExcluir.setOnClickListener(){
            listener.excluirMercado(listaMercado[position])
        }
    }

    override fun getItemCount(): Int {
        return listaMercado.size
    }

    fun refreshListMercado(listaAtualizada: List<Mercado>){
        listaMercado = listaAtualizada
        notifyDataSetChanged()
    }
}
