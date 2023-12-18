package com.example.demo1

data class Hero(val name: String, val imageurl: String)

data class HeroesResponse(val heroes: List<Hero>)