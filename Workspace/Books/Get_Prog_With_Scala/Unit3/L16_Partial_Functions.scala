object PartFunctions extends App {
    val sqrt: PartialFunction[Int, Double] =
        { case x if x >= 0 => Math.sqrt(x) }


    val toPrettyString: PartialFunction[Any, String] = {
        case x: Int if x >=0 => s"positive number: $x"
        case s: String => s
    }

    val transform: PartialFunction[String, String] = {
        case s: String if s.startsWith("a") => s.reverse
        case s: String if s.startsWith("s") => s.toUpperCase
    }

    // Function Composition
    val f: String => Int = _.size
    val g: Int => Boolean = _ > 2

    // val gof: String => Boolean = { s => g(f(s))}
    val gof : String => Boolean = f.andThen(g)

    // Componiedo sqrt
    val zero: PartialFunction[Int, Double] = { case _ => 0 }
    val value: PartialFunction[Int, Double] = { case x => x }
    def sqrtOrZero(n: Int): Double = sqrt.orElse(zero)(n)
    def sqrtOrValue(n: Int): Double = sqrt.orElse(value)(n)

    // Try-Catch
    def n(): Int =
        try {
            throw new Exception("BOOM!")
        } catch {
            case ex: Exception =>
                println(s"Ignoring exception $ex. Returning zero instead")
                0
        }

    // n()
    try {
        val b = "hello".toBoolean
    } catch {
        case _: IllegalArgumentException => false
    }

    val strToInt: PartialFunction[String, Int] = {
        case s: String if s.length() > 0 => s.toInt
        case s:String => s.length()
    }
}