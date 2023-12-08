package com.kkyoungs.myapplication.proxy

class Real_Image(private val fileName: String) :Image {
    init {
        loadFromDisk(fileName)
    }
    private fun loadFromDisk(fileName: String){
        println("Loading $fileName")
    }
    override fun displayImage() {
        println("Displaying $fileName")
    }
}
