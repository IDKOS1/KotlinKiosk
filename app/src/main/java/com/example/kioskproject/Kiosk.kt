
import com.example.kioskproject.Coffee
import com.example.kioskproject.Desert
import com.example.kioskproject.Juice
import com.example.kioskproject.Menu
import com.example.kioskproject.Product
import com.example.kioskproject.Smoothie
import kotlin.collections.mutableListOf
import kotlin.collections.mutableListOf as mutableListOf1

fun main() {
    val menu = initCafeMenu()
    val coffeeMenu = initialCoffeeMenu()
    val juiceMenu = initialJuiceMenu()
    val smoothieMenu = initialSmoothieMenu()
    val desertMenu = initialDesertMenu()
    val cartList: MutableList<Product> = mutableListOf()


    while (true) {
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해 주세요.")
        for(i in menu){
            i.showMenu()
        }

        val selectMenu = readLine()!!.toInt()
        var subMenu = -1
        var isEnd = false

        // 메뉴 선택하는 코드
        while(subMenu !in 0..4) {
            when (selectMenu) {
                1 -> for(sub in coffeeMenu) sub.showMenu()
                2 -> for(sub in juiceMenu) sub.showMenu()
                3 -> for(sub in smoothieMenu) sub.showMenu()
                4 -> for(sub in desertMenu) sub.showMenu()
                0 -> println("시스템을 종료합니다")
                else -> {
                    println("잘못 입력 하셨습니다. 다시 입력 해 주세요.")
                    break
                }
            }

            subMenu = readLine()!!.toInt()

            when (subMenu) {
                in 1..4 -> {
                    println("메뉴션택완료. 종료합니다.")
                    isEnd = true
                    break
                }
                0 -> {
                    println("뒤로가기 선택")
                    println("--------------------------------")
                    break
                }
                else -> {
                    println("잘못 입력 하셨습니다. 다시 입력 해 주세요.")
                    println("--------------------------------")}
            }
        }
        if(isEnd) break
    }
}

fun initCafeMenu() : MutableList<Menu> {
    return mutableListOf1(
        Menu(1, "COFFEE", "에스프레소 샷이 들어간 커피"),
        Menu(2, "JUICE/ADE", "시원한 주스와 에이드"),
        Menu(3, "SMOOTHIE", "얼음을 갈아 만든 스무디"),
        Menu(4, "DESSERT", "음료와 함께 즐길 수 있는 디저트"),
    )
}

fun initialCoffeeMenu() : MutableList<Coffee> {
    return mutableListOf1(
        Coffee(1, "Americano", "시원한 아이스 아메리카노",3.5),
        Coffee(2, "Cafe Latte", "부드러운 카페라떼",4.0),
        Coffee(3, "Vanilla Latte", "달달한 바닐라 라떼",4.5),
        Coffee(4, "Cafe Mocha", "진한 초코 라떼",4.5),
    )
}

fun initialJuiceMenu() : MutableList<Juice> {
    return mutableListOf1(
        Juice(1, "Lemon Ade", "새콤달콤 레몬 에이드",3.5),
        Juice(2, "Grapefruit Ade", "상큼한 자몽에이드",4.0),
        Juice(3, "Apple Juice", "신선한 사과 주스",4.5),
        Juice(4, "Orange Juice", "신선한 오렌지 주스",4.5),
    )
}

fun initialSmoothieMenu() :MutableList<Smoothie> {
    return mutableListOf1(
        Smoothie(1, "Chocolate Smoothie", "달콤한 초콜렛 스무디",3.5),
        Smoothie(2, "Strawberry Smoothie", "신선한 딸기 스무디",4.0),
        Smoothie(3, "Plane Yogurt Smoothie", "달달한 플레인 요거트 스무디",4.5),
        Smoothie(4, "Oreo Smoothie ", "달달한 오레오 스무디",4.5),
    )
}

fun initialDesertMenu() : MutableList<Desert> {
    return mutableListOf1(
        Desert(1, "Chocolate Smoothie", "달콤한 초콜렛 스무디",3.5),
        Desert(2, "Strawberry Smoothie", "신선한 딸기 스무디",4.0),
        Desert(3, "Plane Yogurt Smoothie", "달달한 플레인 요거트 스무디",4.5),
        Desert(4, "Oreo Smoothie ", "달달한 오레오 스무디",4.5),
    )
}



