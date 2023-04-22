package Lesson25

case class WebsiteStats(
    lastHour: Long,
    lastDay: Long,
    lastMonth: Long,
    lastQuarter: Long,
    lastYear: Long
)

case class MyStats(lastDay: Long, lastMonth: Long)

/* Ejemplo malo XD
def lastDayAndMonthStats(): MyStats = {
    val allStats = getStats()
    MyStats(allStats.lastDay, allStats.lastMonth)
}*/
// Mejora usando Tuples
// def lastDayAndMonthStats(): (Long, Long) = {
//     val allStats = getStats()
//    (allStats.lastDay, allStats.lastMonth)
//}

// def get3rdPartStats(): WebsiteStats = ???
// def getStats(): WebsiteStats = ???

object L25 extends App {
    // val stat = lastDayAndMonthStats()
    // decomposing
    // val (lastDay, lastMonth) = lastDayAndMonthStats()
    // una tupla puede tener 1 elemento y maximo 22
    // tambien se pueden crear así: 1 -> 2 ===> (1, 2) que es tipo (Int, Int)
    // 1 -> 2 -> 3 ==> ((Int, Int), Int)
    // usando PattMatch
    val t = ("hello", "Scala", "!")
    t match {
        case (_, _, c) if c == "!" => "?"
        case (a, b, c) => s"$a-$b-$c"
    }
    println(t._1)
    println(t._2)
    println(t._3)

    // QC
    val tri = (5, "Jane", 3)
    val (_, txt, n) = tri
    println(txt * n)

    // Implementando unapply
    case class Person(name: String, age: Int)
    // se ocupa un companion object para aplicar el unapply
    object Person {
        def unapply(p: Person): Option[(String, Int)] =
            if (p.name == "James Bond" || p.name.equalsIgnoreCase("James Bond")) None
            else Some((p.name, p.age))
    }

    // try this
    case class Book(title: String, author: String, pudDate: String, editor: String, isbn: String, pages: Int)
    object Book {
        def unapply(b: Book): Option[(String, String, String)] =
            Some((b.title, b.author, b.isbn))
    }

    val book1 = Book(title = "AWS", author = "Amazon", pudDate = "12/12/12", editor = "AMZ", "123ABC", pages = 10)
    val book2 = Book(title = "GCP", author = "Google", pudDate = "13/12/12", editor = "GCP", "456ABC", pages = 10)
    val book3 = Book(title = "Azure", author = "Microsoft", pudDate = "14/12/12", editor = "AZ", "789ABC", pages = 10)

    val p1 = book1 match {
        case Book(title, author, isbn) if title == "AWS" => 15.68 
    }

    println(p1)
}