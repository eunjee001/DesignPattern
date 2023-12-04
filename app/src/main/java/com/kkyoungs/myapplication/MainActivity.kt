package com.kkyoungs.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kkyoungs.myapplication.factorymethod.EKRamanStore
import com.kkyoungs.myapplication.factorymethod.Raman
import com.kkyoungs.myapplication.prototype.User

class MainActivity : AppCompatActivity() {
    var ekStore = EKRamanStore()
    private lateinit var user : User
    constructor(name : String, job : String, age:Int) :this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        BulDackRaman()
        SinRaman()
        protoTypePattern()

//        raman.getName()
    }

    // factoryMethodPattern
    private fun BulDackRaman() {
        ekStore.orderRaman("BulDak")
    }

    private fun SinRaman() {
        ekStore.orderRaman("Sin")
    }

    // prototypePattern
    private fun protoTypePattern(){
        user.name = "로또"
        user.job = "왕쟈"
        user.age = 4

        println("첫번째 user1" + ", 이름 : "+user.name + ", 직업 : "+user.job + ", 나이 : "+user.age)

        val user2 = user.clone() as User
        println("두번째 user2" + ", 이름 : "+user2.name + ", 직업 : "+user2.job + ", 나이 : "+user2.age)

        user2.name = "꼬미"
        user2.job = "굥쥬"
        user2.age = 1
        println("세번째 user2" + ", 이름 : "+user2.name + ", 직업 : "+user2.job + ", 나이 : "+user2.age)
        println("네번째 user1" + ", 이름 : "+user.name + ", 직업 : "+user.job + ", 나이 : "+user.age)

    }
}