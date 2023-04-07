package my.example.io

import scala.io.{Source as Src}

class MyExample {
    def readFileIntoString(filename: String) =
        Src.fromFile(filename).getLines().mkString("\n")
}
