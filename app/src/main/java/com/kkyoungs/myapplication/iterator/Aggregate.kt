package com.kkyoungs.myapplication.iterator



interface Aggregate {
    fun iterator(): Iterator
}

interface Iterator {
    fun hasNext() :Boolean
    fun next() : Any
}