abstract class Robot(name: String) {
    def welcome: String
}


object Vocabulary {
    val sentenceA = "Hi there!"
    val sentenceB = "Welcome!"
    val sentenceC = "Hello :)"
}

// Companion Object: Tiene el mismo nombre de una clase y nos permite crear metodos estaticos
object Robot {
    def mostTalkative(r1: Robot, r2: Robot): Robot = {
        val r1Size = r1.welcome.length
        val r2Size = r2.welcome.length
        if (r1Size >= r2Size) r1 else r2
    }
}

// Companion Object con Apply
class Person(val name: String, val age: Int)

object Person {
    def apply(p1: Person, p2: Person): Person = {
        val name = s"Son of ${p1.name} and ${p2.name}"
        val age = 0
        new Person(name, age)
    }
    // podemos crear mas de una firma de apply
    def apply(name: String): Person = new Person(name, 0)

    def apply(age: Int): Person = new Person("Mr Desconocido", age)

    def apply(name: String, p1: Person, p2: Person): Person = {
        val age = Math.abs(p1.age - p2.age)
        new Person(name, age)
    }
}
// En Scala 3 automaticamente genera un apply
class Test(val n: Int)
object Test

object SingletonApp {
    @main def Run(): Unit = {
        println("Uso de @main en Scala 3")

        println(Vocabulary.sentenceC)

        // Ejemplo Aplicando Companion Object
        val tom = new Robot("Tom") {
            def welcome = Vocabulary.sentenceA
        }

        val alice = new Robot("Alice") {
            def welcome = Vocabulary.sentenceB
        }

        println(Robot.mostTalkative(tom, alice))

        // Apply
        val tommy = new Person("Tommy", 24)
        val alicia = new Person("Alicia", 23)

        val a = Person.apply(tommy, alicia)
        println(a.name)

        // Apply Scala 3
        println(new Test(5).n)
        println(Test(5).n)

        // Try This
        val b = Person.apply("Jennifer", tommy, alicia)
        println(b.age)

    }
}