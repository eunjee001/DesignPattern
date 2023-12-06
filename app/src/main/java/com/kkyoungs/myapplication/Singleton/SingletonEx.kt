package com.kkyoungs.myapplication.Singleton

import android.content.Context

class SingletonEx{

    /**
     * companion object 로 생성한 파라미터가 있는 싱글톤 클래스는 객체 생성가능
     * 여러개의 객체를 생성할 수 있지만, 클래스의 메모리 주소값은 동일.
     */
    /////
    companion object{
        private var instance : SingletonEx ? = null
        private lateinit var context : Context

        fun getInstance(_context : Context) :SingletonEx{
            return instance?: synchronized(this){
                instance ?: SingletonEx().also {
                    context = _context
                    instance=it
                }
            }
        }
    }
    fun printName (name :String){
        println("name : $name")
    }
}