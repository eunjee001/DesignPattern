package com.kkyoungs.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var ekStore = EKRamanStore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BulDackRaman()
        SinRaman()
    }
    private fun BulDackRaman() {
        ekStore.orderRaman("BulDak")
    }

    private fun SinRaman() {
        ekStore.orderRaman("Sin")
    }
}