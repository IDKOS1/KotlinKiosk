package com.example.kioskproject.Class

import com.example.kioskproject.Class.Menu

open class Product (
    number: Int,
    name: String,
    description: String,
    val price: Double)
    : Menu(number, name, description) {
    open fun showDetail() {
        println("$number. $name | W $price | $description")
    }
}
