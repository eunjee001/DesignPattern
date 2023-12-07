package com.kkyoungs.myapplication.bridge

class Best(override var puppy: Puppy) : Baby(puppy) {
    val type : String = "최고"

    override fun cute() :String {
        return type + " " + puppy.love()
    }
}