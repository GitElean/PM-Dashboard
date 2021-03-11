package com.example.lab3_dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

public class NoticiasAdaptador(private val listener: MutableList<Noticia>):
        RecyclerView.Adapter<NoticiasAdaptador.NoticiasHolder>() {

    private var noticias: MutableList<Noticia> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiasHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_noticia, parent, false)
        return NoticiasHolder(view)
    }

    override fun onBindViewHolder(holder: NoticiasHolder, position: Int) {
        val actual: Noticia = this.noticias[position]
        holder.bind(actual, listener)

    }

    override fun getItemCount(): Int {
        return this.noticias.size
    }

    /***
     *
     */
    class NoticiasHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(noticia: Noticia, listener: MutableList<Noticia>) = with(itemView){
            val txtTitle:TextView = findViewById(R.id.txtTitle)
            val imagen: ImageView = findViewById(R.id.imagen)
            txtTitle.text = noticia.titulo
            Picasso.get().load(noticia.imagen).into(imagen);

            setOnClickListener{
                listener.onItemClicked(adapterPosition)
            }

            setOnLongClickListener{
                listener.onItemLongClicked(adapterPosition)
            }
        }



        interface ClickListener{
            fun onItemClicked(position: Int)

            fun onItemLongClicked(position: Int): Boolean
        }
    }
}