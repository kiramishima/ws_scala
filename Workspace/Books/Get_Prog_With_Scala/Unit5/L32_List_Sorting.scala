object L32 extends App {
    case class Contact(name: String,
                       surname: String,
                       numbers: List[ContactNumber],
                       company: Option[String],
                       email: Option[String]) {

        def toPrettyString: String = s"$surname $name"
    }

    sealed trait Label
    case object Work extends Label
    case object Home extends Label

    case class ContactNumber(number: String, label: Label)

    // L32.2
    def sort(addressBook: List[Contact]): List[Contact] = 
        addressBook.sortBy { contact =>
            (contact.surname, contact.name)
        }

    def describeFirstN(n: Int, addressBook: List[Contact]): String =
        addressBook.take(n).map(_.toPrettyString).mkString("\n")

    // L32.4
    def totalNumbers(addressBook: List[Contact]): Int =
        addressBook.map(_.numbers.size).sum

    // QC 32.3
    def sumOfFirstN(n: Int): Int =
        List.range(0, n+1).sum

    println(sumOfFirstN(10))
    println(sumOfFirstN(-10))

    // grouping
    // 32.5
    def perCompany(
        addressBook: List[Contact]): Map[Option[String], List[Contact]] =
            addressBook.groupBy(_.company)

    // QC 32.4
    def perLetter(addressBook: List[Contact]): Map[Char, List[Contact]] =
        addressBook.groupBy(_.surname.headOption.getOrElse(' '))

    // try this
    case class MarkExam(examName: String, score: Int, studentId: String)

    def getTopMarkExam(exams: List[MarkExam]): String = {
        val top = exams.sortBy(exam => -exam.score)
        val studentsId = top.take(5).map(_.studentId)
        studentsId.mkString("\n")
    }

    val exams = List(MarkExam("Paul", 10, "P33"),
        MarkExam("Raul", 4, "P34"),
        MarkExam("Saul", 0, "P35"),
        MarkExam("Zaul", 7, "P36"),
        MarkExam("Maul", 9, "P37"),
        MarkExam("Naul", 8, "P38"),
        MarkExam("Paul", 1, "P39")
    )

    println(getTopMarkExam(exams))
}
