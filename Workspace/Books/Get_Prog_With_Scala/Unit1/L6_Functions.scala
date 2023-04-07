def pow(exponent: Int, base: Int = 2): Int = {
    var res = 1
    for (i <- 1 to exponent) res *= base
    res
}

def isEven(n: Int): Boolean = {
    n % 2 == 0
}


object Main extends App {
    println(pow(3))
}