object L38 extends App {
    def sqrt(n: Int): Either[String, Double] =
        if (n < 0) Left("Number can't be negative")
        else Right(Math.sqrt(n))

    def sqrtOrZero(n: Int): Double =
        sqrt(n) match {
            case Left(_) => 0
            case Right(r) => r
        }

    def truncate(e: Either[Double, String]): Either[Double, String] =
        e.map(_.take(24))
        // e.right.map(_.take(24)) <- versiones viejas a scala 2.12+

    // Try this
    def validation(a: Either[String, Int], b: Either[String, Int]): Either[List[String], Int] =
        (a, b) match {
            case (Left(v1), Left(v2)) => Left(List(v1, v2))
            case (Right(aa), Right(bb)) => Right(aa + bb)
            case (Left(v1), _) => Left(List(v1))
            case (_, Left(v2)) => Left(List(v2))
        }

    println(validation(Left("first failure"), Left("second failure")))
}
