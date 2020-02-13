package com.example.testefilmemvc.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testefilmemvc.R
import com.example.testefilmemvc.pojos.Filme
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_lista.view.*

class FilmeAdapter(var movieList: MutableList<Filme>, val listener: OnClick) :

    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList.get(position)
        holder.onBind(movie)

        holder.itemView.setOnClickListener {
            listener.onClickFilme(movie)
        }
    }

    fun atualizaLista(newList: MutableList<Filme>) {
        this.movieList.removeAll(movieList)
        this.movieList = newList
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(movie: Filme) {
            itemView.movieName.text = movie.title
            Picasso.get().load(movie.posterPath).into(itemView.movieImage)
        }

    }
}