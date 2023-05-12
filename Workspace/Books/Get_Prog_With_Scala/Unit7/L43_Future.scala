package L43

import java.io.File
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object L43 extends App {
    // try this
    def printDirFiles(dirPath: String) = Future {
        new File(dirPath).listFiles().foreach(println)
    }

    printDirFiles(".")
}
