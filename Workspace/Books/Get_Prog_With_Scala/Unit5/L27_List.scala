
object L27 extends App {
    // QC 27.3
    def sum(nums: List[Int]): Int =
        nums match {
            case Nil => 0
            case head::tail => head + sum(tail)
        }
    // try this
    def filterListEvenNums(nums: List[Int]): List[Int] =
        nums match {
            case Nil => Nil
            case head::tail if head%2 == 0 => head::filterListEvenNums(tail)
            case _::tail => filterListEvenNums(tail)
        }
    //
    val firsList = List(42, "Scala")
    println(firsList)
    // prepend con +:
    val addedNewElement2 = "avada kadravra" +: firsList
    println(addedNewElement2)
    // appending con :+ (es mas costoso que prepend)
    val addedNewElement = firsList :+ "alohomora"
    println(addedNewElement)
    // concatenation con ++
    println(addedNewElement ++ Nil)
    println(addedNewElement ++ addedNewElement2)

    println(sum(List(1, 2, 3, 4)))

    println(filterListEvenNums(List(1, 2, 5, 8, 10)))
}