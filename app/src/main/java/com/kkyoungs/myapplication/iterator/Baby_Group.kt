package com.kkyoungs.myapplication.iterator

class Baby_Group(num : Int) : Aggregate {
    private val baby: Array<Baby?>

    // java 에서 getLength는 그냥 변수 선언 해주기(아래와 같이)
    var length = 0
    init {
        baby = arrayOfNulls(num)
    }

    fun getBaby(index:Int) : Baby?{
        return baby[index]
    }

    fun addBaby(baby :Baby){
        this.baby[length] = baby
        length ++
    }


    override fun iterator(): BabyGroupIterator {
        return BabyGroupIterator(this)
    }
}
