package br.com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.example.myapplication.Model.CategoriaModel
import br.com.example.myapplication.R

class CategoriaAdapter(val contexto: Context, val list: ArrayList<CategoriaModel>,val click: (categoria: CategoriaModel) -> Unit) :
    RecyclerView.Adapter<CategoriaAdapter.ViewHolder>(){
       class ViewHolder(view: View): RecyclerView.ViewHolder(view){
           var text1 = view.findViewById<TextView>(R.id.tvText1)
       }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text1.text= list[position].Nome
        holder.itemView.setOnClickListener{
            click(list[position])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    var view = LayoutInflater.from(contexto).inflate(R.layout.item_menu,parent,false )

        return  ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}


