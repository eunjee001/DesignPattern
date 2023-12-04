package com.kkyoungs.myapplication.factorymethod

import com.kkyoungs.myapplication.factorymethod.Raman

abstract class RamanStore {
        fun orderRaman(type: String): Raman? {
            val raman: Raman? = createRaman(type)
            raman?.prepare()
            raman?.cook()
            raman?.box()

            return raman
        }

        abstract fun createRaman(type:String): Raman?
}