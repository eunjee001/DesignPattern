package com.kkyoungs.myapplication.factorymethod

open class Raman {
    var name :String = ""

    fun prepare(){
        println("--------------------------factoryMethod Pattern------------------------------")

        println("preparing ~ $name")
    }
    fun cook(){
        println("cooking ~ ")
    }

    fun box(){
        println("boxing ~")
    }

    /**
     * 오류 : The following declarations have the same JVM signature (getName()Ljava/lang/String;):
     * ==> @JVMName 으로 오류고침 !
     * JvmName 어노테이션은 코틀린 코드에서 자바 바이트코드로 컴파일될 때 자바와의 이름을 지정하는데에 대한 차이를 매꾸어주기 위해서 사용할 수 있는 어노테이션.
     * 위에 변수명도 name 함수명도 name 이라서 val name 변수에서 getName이라는 메서드를 자동으로 생성해주기때문에 오류가 났었다 !
     * 저 @jvmName 을 해주던가 ! 아니면 함수명을 바꾸쟈 !!
     */
    @JvmName("getName2")
    fun getName():String{
        return name
    }

}

class BulDackRaman: Raman(){
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