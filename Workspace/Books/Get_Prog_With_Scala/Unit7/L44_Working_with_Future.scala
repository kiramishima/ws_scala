package L44

import scala.concurrent.{Future, ExecutionContext}
import scala.concurrent.ExecutionContext.Implicits.global
import java.io.File

object L44 extends App {
    def toInt(s: Future[String])
        (using ec: ExecutionContext): Future[Int] =
        s.map(_.toInt)

    val x = toInt(Future("12"))
    println(x)

    def contentInDir(path: String)
        (using ec: ExecutionContext): Future[List[String]] =
        Future {
            val file = new File(path)
            if (file.isDirectory) file.listFiles().toList.map(_.getAbsolutePath)
            else List.empty
        }

    def countFiles(path: String)
        (using ec: ExecutionContext): Future[Int] = {
        contentInDir(path).map(_.size)
    }
}