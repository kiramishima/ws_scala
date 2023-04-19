case class Brewery(name: String)
case class Beer(name: String, brewery: Brewery)
// Case Class
case class Person(name: String, age: Int)
// Case Object
sealed trait Currency
case object USD extends Currency
case object CAD extends Currency
case object GBP extends Currency
case object EUR extends Currency

// Try This
case class Author(forename: String, surname: String)
sealed trait Genre
case object Drama extends Genre
case object Horror extends Genre
case object Romantic extends Genre
case class Book(title: String, author: Author, genre: Genre)

object L19 extends App {
    def welcome(person: Person): String = person match {
        case Person("Tom", _) => "Hello Mr Tom!"
        case Person(name, age) if age > 18 => s"Good to see you $name"
        case p @ Person(_, 18) => s"${p.name}, you look older!" // bindeamos a p la instancia de la clase usando @
        case Person(_, _) => "Hi bro!"
    }
}