package com.kkyoungs.myapplication

import android.R
import android.R.attr.name


open class Raman {
    var name :String = ""
    val noodle : String = ""
    val sauce : String = ""

    fun prepare(){
        println("preparing ~ $name")
    }
    fun cook(){
        println("cooking ~ ")
    }

    fun box(){
        println("boxing ~")
    }
    fun getName():String{
        return name
    }

}

class BulDackRaman:Raman(){
    init {
        name = "BulDackRaman"
    }
}
class SinRaman : Raman(){
    init {
        name = "SinRaman"
    }
}
class KokKokRaman : Raman(){
    init {
        name = "KokKokKokRaman"
    }
}