package com.kkyoungs.myapplication.iterator

class BabyGroupIterator(babyGroup: Baby_Group) : Iterator {
    private var baby_group : Baby_Group? = null
    private var index : Int = 0

    init {
        this.baby_group = babyGroup
        this.index = 0
    }
    override fun hasNext(): Boolean {
        return index < baby_group?.length!!
    }

    override fun next(): Baby {
        val baby = baby_group?.getBaby(index)
        index++
        return baby!!
    }
}