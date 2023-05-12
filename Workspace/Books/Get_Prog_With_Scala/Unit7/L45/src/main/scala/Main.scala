import scala.concurrent.{ExecutionContext, Future}
import java.io.File

object L45 extends App {
  def firstSuccessful[T](in: List[Future[T]])
    (using ec: ExecutionContext): Future[Option[T]] =
    Future.find(in)(_ => true)

  // Try this
  def contentInDir(path: String)
        (using ec: ExecutionContext): Future[List[String]] =
        Future {
            val file = new File(path)
            if (file.isDirectory) file.listFiles().toList.map(_.getAbsolutePath)
            else List.empty
        }

  def allContentInDir(path: String)
        (using ec: ExecutionContext): Future[List[String]] =
          val futureFiles = contentInDir(path)
          for {
            files <- futureFiles
            subdirs <- Future.sequence(files.map(allContentInDir))
          } yield files ++ subdirs.flatten
}