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
        override fun showMenu() {
            println("$name | $price | $description")
        }
    }

class Coffee (
    number: Int,
    name: String,
    description: String,
    price: Double
    )
    : Product(number, name, description, price) {

    private var isIce: Boolean = true
    fun showDetail() {
        println("$number. $name | $price | $description | ${if(isIce) "ICE" else "HOT"}")
    }
}

class Juice (
    number: Int,
    name: String,
    description: String,
    price: Double)
    : Product(number, name, description, price)

class Smoothie (
    number: Int,
    name: String,
    description: String,
    price: Double)
    : Product(number, name, description, price)

class Desert (
    number: Int,
    name: String,
    description: String,
    price: Double)
    : Product(number, name, description, price)