def stats(s: String,
    predicate: Char => Boolean = {_ => true}): Int =
    s.count(predicate)

def size(s: String): Int = stats(s, _ => true)
def countLetters(s: String): Int = stats(s, _.isLetter)
def countDigits(s: String): Int = stats(s, _.isDigit)

// Quick Check
// def foo(f: Int => Double): Double = f(42) + 2
def foo(f: Int => Double = _.toDouble): Double = f(42) + 2

// Selector de funcion
sealed trait Mode
case object Lenght extends Mode
case object Letters extends Mode
case object Digits extends Mode
case object Whitespaces extends Mode

def predicateSelector(mode: Mode): Char => Boolean =
    mode match {
        case Lenght => _ => true
        case Letters => _.isLetter
        case Digits => _.isDigit
        case Whitespaces => _.isWhitespace
    }

// Try this
def operatioWithFallback(n: Int, operation: Int => Int, fallback: Int): Int = {
    val result = operation(x)
    if (result > 0) result else fallback
}

object L20 extends App {
    val text = "This is my Text Example"
    println(stats(text, _.isUpper))
    println(stats(text, _ == 'x'))

    // usando selector de función
    println(stats(text, predicateSelector(Lenght)))
    println(stats(text, predicateSelector(Letters)))
}