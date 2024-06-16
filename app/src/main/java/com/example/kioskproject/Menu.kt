package com.example.kioskproject

open class Menu (
    val number: Int,
    val name: String,
    val description: String) {
    open fun showMenu() {
        println("$number. $name | $description ")
    }
}

open class Product (
    number: Int,
    name: String,
    description: String,
    val price: Double)
    : Menu(number, name, description) {
    open fun showDetail() {
        println("$number. $name | $price | $description")
    }
}

class Coffee (
    number: Int,
    name: String,
    description: String,
    price: Double,
    private var isIce: Boolean = true
)
    : Product(number, name, description, price) {


    override fun showDetail() {
        println("$number. $name | $price | $description | ${if(isIce) "ICE" else "HOT"}")
    }
    override fun showMenu() {

    }
}

class Juice (
    number: Int,
    name: String,
    description: String,
    price: Double,
    private val fruit: String)
    : Product(number, name, description, price) {
    override fun showDetail() {
        println("$number. $name | $price | $description | 사용 과일: $fruit")
    }
}

class Smoothie (
    number: Int,
    name: String,
    description: String,
    price: Double,
    private val withFruit: Boolean)
    : Product(number, name, description, price) {
    override fun showDetail() {
        println("$number. $name | $price | $description | 과일 함유: ${if(withFruit) "O" else "X"}")
    }
}

class Dessert (
    number: Int,
    name: String,
    description: String,
    price: Double,
    private val dessertKind: String)
    : Product(number, name, description, price) {
    override fun showDetail() {
        println("$number. $name | $price | $description | 디저트 종류: $dessertKind")
    }
}