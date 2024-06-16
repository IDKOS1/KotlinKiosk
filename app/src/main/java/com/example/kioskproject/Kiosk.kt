
import com.example.kioskproject.Coffee
import com.example.kioskproject.Dessert
import com.example.kioskproject.Juice
import com.example.kioskproject.Menu
import com.example.kioskproject.Product
import com.example.kioskproject.Smoothie
import kotlin.collections.mutableListOf

fun main() {
    val menu = initCafeMenu()
    val coffeeMenu = initialCoffeeMenu()
    val juiceMenu = initialJuiceMenu()
    val smoothieMenu = initialSmoothieMenu()
    val desertMenu = initialDesertMenu()
    var cartList: MutableMap<Product, Int> = mutableMapOf()


    while (true) {
        // 메뉴 대분류 출력
        displayMenu(menu)
        // 메뉴 종류 선택(숫자 선택하기)
        val selectMenu = readln().toInt()   //Lv4 예외 처리 필요

        //선택한 메뉴에 따라 상세 메뉴 출력
        when (selectMenu) {
            1 -> {
                val selectSubMenu = displaySubMenu(coffeeMenu as MutableList<Product>)
                if (selectSubMenu != null) cartList[selectSubMenu.first] = selectSubMenu.second
            }
            2 -> {
                val selectSubMenu = displaySubMenu(juiceMenu as MutableList<Product>)
                if (selectSubMenu != null) cartList[selectSubMenu.first] = selectSubMenu.second
            }
            3 -> {
                val selectSubMenu = displaySubMenu(smoothieMenu as MutableList<Product>)
                if (selectSubMenu != null) cartList[selectSubMenu.first] = selectSubMenu.second
            }
            4 -> {
                val selectSubMenu = displaySubMenu(desertMenu as MutableList<Product>)
                if (selectSubMenu != null) cartList[selectSubMenu.first] = selectSubMenu.second
            }

            // 장바구니를 보는 코드
            5 -> {
                println("장바구니 목록")
                for(cart in cartList) {
                    println("${cart.key.name} : ${cart.value}")
                }
                println("--------------------------------")
            }
            0 -> {
                println("시스템을 종료합니다")
                break
            }
            else -> {
                println("잘못 입력 하셨습니다. 다시 입력 해 주세요.")
            }
        }
    }
}

fun displayMenu(menu: MutableList<Menu>) {
    println("아래 메뉴판을 보시고 메뉴를 골라 입력해 주세요.")
    for(m in menu){
        m.showMenu()
    }
    println("5. 장바구니 확인 및 주문 하기")
    println("0. 종료")
}

fun displaySubMenu(subMenu: MutableList<Product>): Pair<Product, Int>? {
    for(sub in subMenu) sub.showDetail()
    val numberMenu = subMenu.size
    println("0. 뒤로가기")

    val subMenuNumber = readLine()!!.toInt()            //Lv4 예외 처리 필요

    while(true) {
        when (subMenuNumber) {
            in 1..numberMenu -> {
                print("선택한 메뉴 : ")
                println(subMenu[subMenuNumber - 1].showDetail())
                println("수량을 선택해 주세요.")
                val number = readLine()!!.toInt()       //Lv4 예외 처리 필요
                while(true) {
                    println("장바구니에 추가 하시겠습니까?")
                    println("[Y / N]")
                    val userAnswer = readlnOrNull()     //Lv4 예외처리 필요
                    when (userAnswer) {
                        "y", "Y" -> {
                            println("장바구니 추가 완료")
                            return Pair(subMenu[subMenuNumber - 1], number)
                        }
                        "n", "N" -> {
                            println("선택을 취소 하셨습니다.")
                            return null
                        }
                        else -> {
                            println("잘못 입력 하셨습니다.")
                        }
                    }
                }
            }

            0 -> {
                println("뒤로가기 선택")
                println("--------------------------------")
                return null
            }
            else -> {
                println("잘못 입력 하셨습니다. 다시 입력 해 주세요.")
                println("--------------------------------")
            }
        }
    }
}

fun initCafeMenu() : MutableList<Menu> {
    return mutableListOf(
        Menu(1, "COFFEE", "에스프레소 샷이 들어간 커피"),
        Menu(2, "JUICE/ADE", "시원한 주스와 에이드"),
        Menu(3, "SMOOTHIE", "얼음을 갈아 만든 스무디"),
        Menu(4, "DESSERT", "음료와 함께 즐길 수 있는 디저트"),
    )
}

fun initialCoffeeMenu() : MutableList<Coffee> {
    return mutableListOf(
        Coffee(1, "Americano", "시원한 아이스 아메리카노",3.5, true),
        Coffee(2, "Cafe Latte", "부드러운 카페라떼",4.0, false),
        Coffee(3, "Vanilla Latte", "달달한 바닐라 라떼",4.5, false),
        Coffee(4, "Cafe Mocha", "진한 초코 라떼",4.5,true),
    )
}

fun initialJuiceMenu() : MutableList<Juice> {
    return mutableListOf(
        Juice(1, "Lemon Ade", "새콤달콤 레몬 에이드",3.5, "Lemon"),
        Juice(2, "Grapefruit Ade", "상큼한 자몽에이드",4.0, "Grapefruit"),
        Juice(3, "Apple Juice", "신선한 사과 주스",4.5, "Apple"),
        Juice(4, "Orange Juice", "신선한 오렌지 주스",4.5, "Orange"),
    )
}

fun initialSmoothieMenu() :MutableList<Smoothie> {
    return mutableListOf(
        Smoothie(1, "Blueberry Smoothie", "새콤 블루베리 스무디",3.5, true),
        Smoothie(2, "Strawberry Smoothie", "신선한 딸기 스무디",4.0, true),
        Smoothie(3, "Plane Yogurt Smoothie", "달달한 플레인 요거트 스무디",4.5, false),
        Smoothie(4, "Oreo Smoothie ", "달달한 오레오 스무디",4.5, false),
    )
}

fun initialDesertMenu() : MutableList<Dessert> {
    return mutableListOf(
        Dessert(1, "Cheese Cake", "부드러운 치즈 케이크",3.5, "Cake"),
        Dessert(2, "Chocolate Cake", "달콤한 초콜렛 케이크",4.0, "Cake"),
        Dessert(3, "Salt Bread", "고소한 소금 빵",4.5, "Bread"),
        Dessert(4, "Vanilla Ice Cream ", "달달한 바닐라 아이스크림",4.5, "Ice Cream"),
    )
}
