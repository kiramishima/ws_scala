trait Animal {
    def sleep = "ZzZ"

    def eat (food: String): String

    def move(x: Int, y:Int): String
}

// Scala 2

trait Nameable {
    def name: String
}

// Scala 3, puede definirse con parametros
// trait Nameable(name: String)

// Usando un Trait
class Cat extends Animal {
    override def sleep: String = "sleepy cat!"
    // En eat y move no necesita override , ya que se implementa la función abstracta
    def eat(food: String): String = s"the cat is eating $food"

    def move(x: Int, y: Int): String = s"the cat is moving to ($x, $y)"
}

class Dog(val name: String) extends Animal with Nameable { // Cuando ocupamos más de un Trait lo agregamos con with
    def eat(food: String): String = s"$food $food"

    def move(x: Int, y: Int): String = s"let's go to ($x, $y)"
}

// Sealed Traits: Los que extiendan de un Sealed deben estar en el mismo archivo.
// Nota: Se parece a las union de F# pero aplicado diferente XD
sealed trait Suit

object Clubs extends Suit
object Diamonds extends Suit
object Hearts extends Suit
object Spades extends Suit

// QC
sealed trait Currency1
object USD extends Currency1
object CAD extends Currency1
object EUR extends Currency1

// Try This
trait Color {
    def color: String
}
class Furniture(val color: String) extends Color
class Clothes(val color: String) extends Color

object Lesson12 {
    // Enums: Introducido en Scala 3
    enum Suit {
        case Clubs, Diamonds, Hearts, Spades
    }

    enum Country(val code: String) {
        case Italy extends Country("IT")
        case UnitedKingdom extends Country("UK")
        case UnitedStates extends Country("US")
        case Japan extends Country("JP")
    }
    // QC
    enum Currency(val code: String) {
        case USD extends Currency("USD")
        case CAD extends Currency("CAD")
        case EUR extends Currency("EUR")
    }
    // Aplicando lo de interfaces
    def feedTreat(animal: Animal) =
        animal.eat("treat")

    def welcome(nameable: Nameable) =
        println(s"Hi, ${nameable.name}")

    @main def Run() = {
        val tigerTheDog = new Dog("Tiger")
        val cat = new Cat

        println(feedTreat(tigerTheDog))
        println(feedTreat(cat))

        welcome(tigerTheDog)
        // welcome(cat) // No compila x que cat no implementa Nameable

        // Enums & Sealed
        println(Suit.Hearts)
        println(Suit.values)
        println(Suit.fromOrdinal(0))

        
        println(Country.Italy.code)

        // Try This Test
        val playera = new Clothes("Azul")
        println(playera.color)
    }
}