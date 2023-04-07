def everOrOdd(n: Int) =
    if (n%2 == 0) println(s"$n is Even")
    else println(s"$n is Odd")

def count()= {
    var i = 1
    while(i <= 10) {
        println(i)
        i += 1
    }
}

object Main extends App {
    for (a <- "hello") println(a)
    everOrOdd(2)
    count()

    for(i <- 1 to 5) println(s"i = $i")
    for(i <- 1 until 5) println(s"x = $i")
}