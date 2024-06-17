package com.example.kioskproject.Class

open class Menu (
    val number: Int,
    val name: String,
    val description: String) {
    open fun showMenu() {
        println("$number. $name | $description ")
    }
}



