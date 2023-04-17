sealed trait Currency

object USD extends Currency
object GBP extends Currency
object EUR extends Currency
object CAD extends Currency

// Para mostrar warnings, podemos agregar en build.sbt => scalacOptions += "-Xfatal-warnings"
object PM extends App {
    def exchangeRateUSD(currency: Currency): Double =
        currency match {
            case USD => 1
            case GBP => 0.744
            case EUR => 0.848
            case CAD => 1.278
        }
    def applyDiscount(price: Double): Double = 
        price match {
            case p if p >= 100 => 0.15
            case p if p >= 50 => 0.10
            case _ => 0
        }
    // Try This Ex
    println(exchangeRateUSD(CAD))
    for (p <- List(10, 60, 110)) println(applyDiscount(p))
}