import java.time.LocalDate

object L36 extends App {
    // Listing 36.1
    case class Student(id: Int, name: String)
    case class ExamSession(name: String, localDate: LocalDate)

    val historySession = ExamSession(name = "History", localDate = LocalDate.now.plusDays(30))
    val chemistrySession = ExamSession(name = "Chemistry", localDate = LocalDate.now.plusDays(45))

    val alice = Student(id = 1, name = "Alice")
    val bob = Student(id = 2, name = "Bob")
    val charlie = Student(id = 3, name = "Charlie")

    val registrations: Map[ExamSession, List[Student]] =
        Map(
            historySession -> List(alice, bob),
            chemistrySession -> List(alice, charlie)
        )

    println(registrations)
    // QC36.1
    val dayOfWeeks: Map[Int, String] =
        Map(1 -> "Monday", 2 -> "Tuesday", 3 -> "Wednesday", 4 -> "Thursday", 5 -> "Friday", 6 -> "Saturday", 7 -> "Sunday")

    // 36.2
    val mathSession = ExamSession("Math", localDate = LocalDate.now)
    // agregando y removiendo
    val registrations2 = registrations + (mathSession -> List(bob))
        - chemistrySession

    println(registrations2)

    // 36.3
    // merge con ++. Si tienen la misma llave va a tomar el del lado B
    // con -- eliminas elementos del map basado en sus llaves

    //QC36.3
    val weeksDays = dayOfWeeks -- Set(1, 2, 3, 4, 5)

    println(dayOfWeeks)
    println(weeksDays)

    // Try this
    val capCountry = Map("Mexico City" -> "Mexico", "Paris" -> "France")
    val countryContinent = Map("Mexico" -> "America", "France" -> "Europe")

    def capitalToContinent(capitalCountry: Map[String, String], countryContinent: Map[String, String]): Map[String, String] =
        for {
            (capital, country) <- capitalCountry
            (country2, continent) <- countryContinent
            if (country == country2)
        } yield capital -> continent

    println(capitalToContinent(capCountry, countryContinent))
}
