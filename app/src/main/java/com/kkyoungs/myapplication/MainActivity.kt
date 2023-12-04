package com.kkyoungs.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var ekStore = EKRamanStore()

    var raman =Raman()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BulDackRaman()
        SinRaman()
//        raman.getName()
    }
    private fun BulDackRaman() {
        ekStore.orderRaman("BulDak")
    }

    private fun SinRaman() {
        ekStore.orderRaman("Sin")
    }
}