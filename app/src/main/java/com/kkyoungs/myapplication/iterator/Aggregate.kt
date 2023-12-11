package com.kkyoungs.myapplication.iterator



interface Aggregate {
    abstract fun iterator(): Iterator
}

interface Iterator {
    abstract fun hasNext() :Boolean
    abstract fun next() : Any
}