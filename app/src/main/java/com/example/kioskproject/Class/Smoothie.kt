package com.example.kioskproject.Class

class Smoothie (
    number: Int,
    name: String,
    description: String,
    price: Double,
    private val withFruit: Boolean)
    : Product(number, name, description, price) {

    // 부모 클래스(Product)의 showDetail 사용 실습을 위한 주석 처리
    /*
    override fun showDetail() {
         println("$number. $name | W $price | $description | 과일 함유: ${if(withFruit) "O" else "X"}")
     }
     */
}
