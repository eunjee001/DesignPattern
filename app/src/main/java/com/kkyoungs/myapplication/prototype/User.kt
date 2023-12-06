package com.kkyoungs.myapplication.prototype

class User : Cloneable {
    var name: String? = null
    var job: String? = null
    var age = 0

    /* 깊은 복사를 위해 Clone() 재정의 */
    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        return super.clone()
    }
}