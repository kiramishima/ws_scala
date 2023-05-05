object L39 extends App {
    def gerOrZero(value: Either[String, Double]): Double =
        value.getOrElse(0)

    def isPositive(value: Either[String, Double]): Boolean =
        value.exists(_ > 0)

    // try this
    def isScala(value: Either[String, Int]): Boolean =
        value.left.exists(_ == "Scala")
}
