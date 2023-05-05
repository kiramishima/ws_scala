object L37 extends App {
    def getCountry(capitalToCountry: Map[String, String], capital: String): String =
        capitalToCountry.getOrElse(capital, "Unknown")

    def getCapitals(capitalToCountry: Map[String, String]): List[String] =
        capitalToCountry.keys.toList

    def longestCapitalName(capitalToCountry: Map[String, String]): String = {
        val (capital, _) = capitalToCountry.maxBy {
            case (capital, _) => capital.length
        }
        capital
    }

    // Try this
    val capCountry = Map("Mexico City" -> "Mexico", "Paris" -> "France")
    val countryContinent = Map("Mexico" -> "America", "France" -> "Europe")

    def capitalToContinent(capitalCountry: Map[String, String], countryContinent: Map[String, String]): Map[String, String] =
        for {
            (capital, country) <- capitalCountry
            (_, continent) <- countryContinent.get(country)
        } yield capital -> continent

    println(capitalToContinent(capCountry, countryContinent))
}
