package com.kkyoungs.myapplication

class EKRamanStore:RamanStore() {
    override fun createRaman(type: String): Raman {
         when (type) {
             "BulDack" -> {
                 return BulDackRaman()
             }

             "Sin" -> {
                 return SinRaman()
             }

             "Kok" -> {
                 return KokKokRaman()
             }

         }
        return Raman()
    }
}