package com.example.testefilmemvc.remote

import com.example.testefilmemvc.pojos.Filme
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmeAPI {
    @GET("movie/now_playing?api_key=bde8033d3274c91b292a5293c6349052")
    fun getFilmesNowPlaying(): Observable<List<Filme>>
//         fun getKey(
//            @Query("api_key") api: String
//        )
}
