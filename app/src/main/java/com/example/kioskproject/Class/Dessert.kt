package com.example.kioskproject.Class

class Dessert (
    number: Int,
    name: String,
    description: String,
    price: Double,
    private val dessertKind: String)
    : Product(number, name, description, price) {
    override fun showDetail() {
        println("$number. $name | W $price | $description | 디저트 종류: $dessertKind")
    }
}