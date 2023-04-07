abstract class Machine {
    def buy(product: String, money: Double): String
    def isProductAvailable(product: String): Boolean
    def isMoneyEnough(product: String, money: Double): Boolean
    def completeRequest(product: String, money: Double): String
}

class VendingMachine extends Machine {
    var chocolateBar = 0
    var granolaBar = 0

    var totalMoney = 0.0

    def buy(product: String, money: Double): String =
    if (!isProductAvailable(product))
        s"Sorry, product $product not available"
    else if (!isMoneyEnough(product, money))
        "Please, insert more money"
    else completeRequest(product, money)

    def isProductAvailable(product: String): Boolean = {
        val productQuantity = {
            if (product == "chocolate") chocolateBar
            else if (product == "granola") granolaBar
            else 0
        }
        productQuantity > 0
    }

    def isMoneyEnough(product: String, money: Double): Boolean = {
        val cost = if (product == "chocolate") 1.5 else 1
        money >= cost
    }

    def completeRequest(product: String, money: Double): String = {
        collectMoney(money)
        releaseProduct(product)
        s"Ther you go! Have a $product bar"
    }

    def collectMoney(money: Double) =
        totalMoney += money

    def releaseProduct(product: String) =
        if (product == "chocolate") chocolateBar -= 1
        else if (product == "granola") granolaBar -= 1
}

object Main extends App {
    val machine = new VendingMachine
    println(machine.buy("chocolate", 1.5))

    println(machine.chocolateBar)

    // Refill
    machine.chocolateBar += 2
    machine.granolaBar += 1

    // Volver a comprar
    println(machine.buy("chocolate", 1.5))
    println(machine.buy("granola", 2))

    // comprando con poco dinero
    println(machine.buy("chocolate", 1))

    // comprando producto no disponible
    println(machine.buy("granola", 2))

    // Total del dinero
    println(machine.totalMoney)
}