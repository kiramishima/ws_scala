object L22 extends App {

    def sqrt(n: Int): Option[Double] =
        if (n >= 0) Some(Math.sqrt(n)) else None

    def filter(text: String, word: String): Option[String] =
        if (text.contains(word)) Some(text) else None

    // PartialFunctions que podría regresar un MatchError !!
    val log: PartialFunction[Int, Double] =
        { case x if x > 0 => Math.log(0) }

    // Version mejorada, como total function
    val logWithOption(x : Int): Option[Double] = x match {
            case x if x > 0 => Some(Math.log(0))
            case _ => None
        }

    // QC 22.2
    def greetings(custonMsg: Option[String]): String = custonMsg match {
        case Some(msg) => msg
        case None => "Greetings, Human!"
    }

    // Try this
    case class Person(first_name: String, middlename: Option[String], lastname: Option[String])

    def fullName(person: Person): String = person match {
            case Person(fn, Some(mn), ln) => s"$fn $mn $ln"
            case Person(fn, None, ln) => s"$fn $ln"
        }

    val george = Person(first_name = "George", middlename = Some("Watson"), lastname = "Lucas")
    println(fullName(george))

    val martin = Person(first_name = "Martin", middlename = None, lastname = "Odersky")
    println(fullName(martin))
}