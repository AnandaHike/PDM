package com.ananda.app11_cadastrotarefafoto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessControlContext

class TarefaAdapter(var listaTarefas: MutableList<Tarefas>, var context: Context):RecyclerView.Adapter<TarefaAdapter>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtTitulo: TextView = view.findViewById(R.id.txtTitulo)
        val txtDescricao: TextView = view.findViewById(R.id.txtDescricao)
        val txtDiaSemana: TextView = view.findViewById(R.id.txtDiaSemana)
        val txtDificuldade: TextView = view.findViewById(R.id.txtDificuldade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaTarefas[position].foto?.let{
            holder.imgFoto.setImageBitmap(it)
        }
        holder.txtTitulo.text = listaTarefas[position].titulo
        holder.txtDescricao.text = listaTarefas[position].descricao
        holder.txtDiaSemana.text = listaTarefas[position].diasemana.nome
        holder.txtDificuldade.text = listaTarefas[position].dificuldade.nome

        // Implementando o "click" do CardView para retornar um Toast como mensagem
        holder.itemView.setOnClickListener(){
            var texto = if (listaTarefas[position].obrigatorio) {
                "Essa tarefa é obrigatória!"
            }
            else
            {
                "Essa tarefa não é obrigatória"
            }

            Toast.makeText(context, texto, Toast.LENGTH_SHORT).show()
        }
    }

    // Indica quantos registros/itens a lista possui
    override fun getItemCount(): Int {
        return listaTarefas.size
    }
}