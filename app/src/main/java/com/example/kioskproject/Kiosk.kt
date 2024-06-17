
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
    var orderNum = 1


    while (true) {
        // 메뉴 대분류 출력
        displayMenu(menu)
        // 메뉴 종류 선택(숫자 선택하기)
        val selectMenu = isInt()

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
                if(cartList.isEmpty()) {
                    println("장바구니가 비어있습니다.")
                    continue
                }
                // 카트가 비어있을 시 결제 완료, 아니면 장바구니 수정 및 뒤로 가기 선택
                val cart = showCart(cartList, orderNum)
                if(cart.first.isEmpty()) {
                    if(cart.second){
                        orderNum++
                        cartList = cart.first
                    } else {
                        cartList = mutableMapOf()
                    }

                } else {
                    cartList = cart.first
                }
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
    println("-------- 카페 메뉴 주문하기 --------")
    println("아래 메뉴판을 보시고 메뉴를 골라 입력해 주세요.")
    for(m in menu){
        m.showMenu()
    }
    println("5. 장바구니 확인 및 주문 하기")
    println("0. 종료")
}

fun displaySubMenu(subMenu: MutableList<Product>): Pair<Product, Int>? {
    var subMenuNumber:Int = 0
    val numberMenu = subMenu.size

    while(true) {
        for(sub in subMenu) sub.showDetail()
        println("0. 뒤로가기")

        subMenuNumber = isInt()
        when (subMenuNumber) {
            in 1..numberMenu -> {
                print("선택한 메뉴 : ")
                subMenu[subMenuNumber - 1].showMenu()
                println("수량을 선택해 주세요.")
                val number = isInt()
                while(true) {
                    println("장바구니에 추가 하시겠습니까?")
                    println("[Y / N]")
                    // 선택 확정 선택
                    val userAnswer = readlnOrNull()     //Lv4 예외 처리 필요
                    when (userAnswer) {
                        "y", "Y", "ㅛ" -> {
                            println("장바구니 추가 완료")
                            return Pair(subMenu[subMenuNumber - 1], number)
                        }
                        "n", "N", "ㅜ" -> {
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

fun showCart(cartList: MutableMap<Product, Int>, orderNum: Int): Pair<MutableMap<Product, Int>, Boolean> {
    while(true) {
        var totalPrice = 0.0
        println("[장바구니 목록]")
        for (cart in cartList) {
            println("${cart.key.name} | 수량: ${cart.value} | 가격: W ${cart.key.price * cart.value}")
            totalPrice += cart.key.price * cart.value
        }
        println("전체 금액: W $totalPrice")
        println("1. 결제 하기")
        println("2. 메뉴 수정 및 삭제")
        println("0. 뒤로가기")
        val chooseCart = isInt()
        when (chooseCart) {
            1 -> {
                println("총 금액은 W $totalPrice 입니다.")
                println("결제할 금액을 선택해 주세요.")
                val payMoney = isDouble()
                if (payMoney >= totalPrice) {
                    println("결제가 완료 되었습니다.")
                    println("거스름 돈은 W ${payMoney - totalPrice} 입니다.")
                    println("주문 번호는 $orderNum 번 입니다. 잠시만 기다려 주세요")
                    return Pair(mutableMapOf(), true)
                } else {
                    println("현재 잔액은 $payMoney W으로 ${String.format("%.1f",  totalPrice - payMoney)}W이 부족해서 주문할 수 없습니다.")
                }
            }
            // 장바구니 메뉴 수정 하기
            2 -> {
                while (true) {
                    if (cartList.isEmpty()) {
                        println("장바구니가 비어있습니다. 메뉴를 추가해 주세요.")
                        println()
                        return Pair(cartList, false)
                    }
                    var num = 1

                    // currentCartList 의 Key 값 저장
                    val menuList = mutableListOf<Product>()

                    println("[장바구니 수정 하기]")
                    println("수정할 메뉴를 선택하세요.")
                    for (cart in cartList) {
                        println("[$num] ${cart.key.name} | 수량: ${cart.value} ")
                        menuList += cart.key
                        num++
                    }
                    println("[0] 뒤로 가기")

                    val fixSelect = isInt()
                    when (fixSelect) {
                        in 1..cartList.size -> {
                            println("몇개로 수정 하시겠습니까? (0개 입력시 장바구니에서 제외)")
                            val fixNumber = isInt()
                            if (fixNumber == 0) {
                                cartList.remove(menuList[fixSelect -1])
                            } else {
                                cartList[menuList[fixSelect -1]] = fixNumber
                            }
                            println("수정 완료")
                        }
                        0 -> break

                        else -> println("잘못 입력 하셨습니다.")
                    }
                }
            }

            0 -> return Pair(cartList, false)
            else -> println("잘못 입력 하셨습니다.")
        }
        println("--------------------------------")
    }
}

// 숫자만 입력 가능하게 예외처리
fun isInt(): Int {
    while(true) {
        try {
            return readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println("숫자만 입력해 주세요.")
        }
    }
}
// double형 예외처리
fun isDouble(): Double {
    while(true) {
        try {
            return readLine()!!.toDouble()
        } catch (e: NumberFormatException) {
            println("숫자만 입력해 주세요.")
        }
    }
}
fun initCafeMenu() : MutableList<Menu> {
    return mutableListOf(
        Menu(1, "COFFEE", "에스프레소 샷이 들어간 커피"),
        Menu(2, "JUICE/ADE", "시원한 주스와 에이드"),
        Menu(3, "SMOOTHIE", "얼음을 갈아 만든 스무디"),
        Menu(4, "DESSERT", "음료와 함께 즐기는 디저트"),
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
