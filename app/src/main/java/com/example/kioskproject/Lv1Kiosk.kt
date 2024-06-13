

fun main() {
    while (true) {
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해 주세요.")
        println("[KOTLIN CAFE]")
        println("1. COFFEE       | 에스프레소 샷이 들어간 커피")
        println("2. JUICE/ADE    | 시원한 주스와 에이드")
        println("3. SMOOTHIE     | 얼음을 갈아 만든 스무디")
        println("4. DESSERT      | 음료와 함께 즐길 수 있는 디저트")
        println("0. EXIT         | 시스템을 종료합니다.")

        val menu = readLine()!!.toInt()
        var subMenu = 0

        when (menu) {
            1 -> subMenu = showCoffee()
            2 -> subMenu = showJuice()
            3 -> subMenu = showSmoothie()
            4 -> subMenu = showDesert()
            0 -> {
                println("시스템을 종료합니다")
                break
            }
            else -> println("잘못 입력 하셨습니다. 다시 입력 해 주세요.")
        }

        when(subMenu) {
            in 1..4 -> {
                println("메뉴션택완료. 종료합니다.")
                break
            }
        }
    }
}

fun showCoffee(): Int {
    var chooseMenu = 0
    println("[COFFEE MENU]")
    println("1. Americano               | W 3.5")
    println("2. Cafe Latte              | W 4.0")
    println("3. Vanilla Latte           | W 4.5")
    println("4. Cafe Mocha              | W 4.5")
    println("0. 뒤로 가기")

    chooseMenu = readLine()!!.toInt()
    when (chooseMenu) {
        1 -> println("1번선택")
        2 -> println("2번선택")
        3 -> println("3번선택")
        4 -> println("4번선택")
        0 -> println("뒤로가기 선택")
        else -> println("잘못 입력 하셨습니다. 다시 입력 해 주세요.")
    }

    return chooseMenu
}

fun showJuice (): Int {
    var chooseMenu = 0
    println("[JUICE/ADE MENU]")
    println("1. Lemon Ade               | W 4.0")
    println("2. Grapefruit Ade          | W 4.0")
    println("3. Apple Juice             | W 5.0")
    println("4. Orange Juice            | W 5.0")
    println("0. 뒤로 가기")

    chooseMenu = readLine()!!.toInt()
    when (chooseMenu) {
        1 -> println("1번선택")
        2 -> println("2번선택")
        3 -> println("3번선택")
        4 -> println("4번선택")
        0 -> println("뒤로가기 선택")
        else -> println("잘못 입력 하셨습니다. 다시 입력 해 주세요.")
    }


    return chooseMenu
}

fun showSmoothie (): Int {
    var chooseMenu = 0
    println("[SMOOTHIE MENU]")
    println("1. Chocolate Smoothie      | W 6.0")
    println("2. Strawberry Smoothie     | W 6.0")
    println("3. Plane Yogurt Smoothie   | W 6.0")
    println("4. Oreo Smoothie           | W 6.0")
    println("0. 뒤로 가기")

    chooseMenu = readLine()!!.toInt()
    when (chooseMenu) {
        1 -> println("1번선택")
        2 -> println("2번선택")
        3 -> println("3번선택")
        4 -> println("4번선택")
        0 -> println("뒤로가기 선택")
        else -> println("잘못 입력 하셨습니다. 다시 입력 해 주세요.")
    }


    return chooseMenu
}

fun showDesert(): Int {
    var chooseMenu = 0
    println("[DESSERT MENU]")
    println("1. Cheese Cake             | W 4.5")
    println("2. Chocolate Cake          | W 4.5")
    println("3. Salt Bread              | W 3.0")
    println("4. Croissant               | W 3.5")
    println("0. 뒤로 가기")

    chooseMenu = readLine()!!.toInt()
    when (chooseMenu) {
        1 -> println("1번선택")
        2 -> println("2번선택")
        3 -> println("3번선택")
        4 -> println("4번선택")
        0 -> println("뒤로가기 선택")
        else -> println("잘못 입력 하셨습니다. 다시 입력 해 주세요.")
    }

    return chooseMenu
}

