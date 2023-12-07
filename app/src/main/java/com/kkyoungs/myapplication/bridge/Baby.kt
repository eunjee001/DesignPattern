package com.kkyoungs.myapplication.bridge

/**
 * cute()메소드를 abstract로 선언해서 하위클래스에게 구현 위임.(override)
 */
abstract class Baby protected constructor(protected open var puppy: Puppy) {
    abstract fun cute(): String?
}