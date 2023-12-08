package com.kkyoungs.myapplication.proxy


class Proxy_Image(private val fileName: String) : Image{
    private var realImage: Real_Image? = null

    override fun displayImage() {
        if (realImage == null) {
            realImage = Real_Image(fileName)
        }
        realImage!!.displayImage()
    }

}