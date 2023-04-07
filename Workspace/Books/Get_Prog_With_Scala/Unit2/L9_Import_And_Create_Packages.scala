//import scala.io.Source
// import scala.io.{Source => Src} // Import con alias Scala v2
import scala.io.{Source as Src} // Alias Scala v3
import scala.math.{BigDecimal, BigInt}
// QC9.1
import java.sql.{Date as SqlDate}

def readFileIntoString(filename: String) =
    Src.fromFile(filename)
        .getLines()
        .mkString("\n")

object Main extends App {
    println("Hello")
}

