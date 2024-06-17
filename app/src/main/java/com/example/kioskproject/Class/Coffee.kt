package com.example.kioskproject.Class

class Coffee (
    number: Int,
    name: String,
    description: String,
    price: Double,
    private var isIce: Boolean = true
) : Product(number, name, description, price) {

    override fun showDetail() {
        println("$number. $name | W $price | $description | ${if(isIce) "ICE" else "HOT"}")
    }
}
