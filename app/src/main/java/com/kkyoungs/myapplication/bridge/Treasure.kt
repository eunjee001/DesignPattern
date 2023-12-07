package com.kkyoungs.myapplication.bridge

class Treasure(override var puppy: Puppy) : Baby(puppy) {
    val type : String = "보물"

    override fun cute() :String {
        return type + " " + puppy.love()
    }
}