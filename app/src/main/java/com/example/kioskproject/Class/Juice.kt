package com.example.kioskproject.Class

class Juice (
    number: Int,
    name: String,
    description: String,
    price: Double,
    private val fruit: String)
    : Product(number, name, description, price) {
    override fun showDetail() {
        println("$number. $name | W $price | $description | 사용 과일: $fruit")
    }
}
