package com.example.testefilmemvc.pojos

import java.io.Serializable


data class Filme (
    val posterPath: String,
    val duration: String,
    val id: String,
    val overview: String,
    val title: String
):Serializable