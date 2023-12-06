package com.kkyoungs.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kkyoungs.myapplication.Singleton.SingletonEx
import com.kkyoungs.myapplication.factorymethod.EKRamanStore
import com.kkyoungs.myapplication.prototype.User

class MainActivity : AppCompatActivity() {
    var ekStore = EKRamanStore()

    /**
     * 오류내용 : Cannot access '<init>': it is package-private in 'User'
     * User 초기화 요류가 났지만 User class에서 오버라이딩 한부분을 제거하고 아래와같이 초기화 하였더니 오류 해결 ~!
     */
    
    private var user = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BulDackRaman()
        SinRaman()
        protoTypePattern()
        testSingleTon()
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

        println("--------------------------prototype Pattern------------------------------")
        println("첫번째 user1" + ", 이름 : "+user.name + ", 직업 : "+user.job + ", 나이 : "+user.age)

        val user2 = user.clone() as User
        println("두번째 user2" + ", 이름 : "+user2.name + ", 직업 : "+user2.job + ", 나이 : "+user2.age)

        user2.name = "꼬미"
        user2.job = "굥쥬"
        user2.age = 1
        println("세번째 user2" + ", 이름 : "+user2.name + ", 직업 : "+user2.job + ", 나이 : "+user2.age)
        println("네번째 user1" + ", 이름 : "+user.name + ", 직업 : "+user.job + ", 나이 : "+user.age)

    }

    // SingleTonPattern
    private fun testSingleTon(){
        println("----------------------------singleton Pattern -------------------------------------")
        val singleton1 = SingletonEx.getInstance(this)
        val singleton2 = SingletonEx.getInstance(this)
        singleton1.printName("로또")
        singleton2.printName("꼬미")
        SingletonEx.getInstance(this).printName("메롱")
    }
}