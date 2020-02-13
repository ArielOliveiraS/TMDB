package com.example.testefilmemvc.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testefilmemvc.R
import com.example.testefilmemvc.pojos.Filme
import com.example.testefilmemvc.remote.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnClick {

    var movieList: MutableLiveData<List<Filme>> = MutableLiveData()
    var list = mutableListOf<Filme>()

    val api_key: String = "bde8033d3274c91b292a5293c6349052"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllMovies()

//    viewModel.movieListResult.observe(this, Observer {
//        adapter.updateList(it as MutableList<MovieResult>)
//    })

        var adapter = FilmeAdapter(list, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)


    }

    override fun onClickFilme(filme: Filme) {
        val intent = Intent(this, DetalheActivity::class.java)
        intent.putExtra("filme", filme)
        startActivity(intent)
    }

    fun getAllMovies() {
            RetrofitService.service.getFilmesNowPlaying()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    movieList.value = it
                }, { throwable ->
                    Log.i("LOG", "erro" + throwable.message)
                })

    }
}








