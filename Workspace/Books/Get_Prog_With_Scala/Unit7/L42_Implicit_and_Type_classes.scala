import java.util.Currency

object L42 extends App {
    // type classes
    trait Show[T] {
        def show(t: T): String
    }

    object Show {
        // scala 2 seria -> implicit val stringShow: Show[String] = new Show[String] {...}
        given stringShow: Show[String] with {
            override def show(s: String): String = s
        }

        given intShow: Show[Int] with {
            override def show(i: Int): String = i.toString
        }

        given listShow[T]: Show[List[T]] with {
            override def show(l: List[T]): String = l.mkString(", ")
        }

        // QC 42.3
        given personShow[T]: Show[Person] with {
            override def show(p: Person): String = s"${p.name} (${p.age})"
        }
    }

    def prettyPrintln[T](t: T)(using s: Show[T]): Unit =
        println(s.show(t))

    prettyPrintln(1)
    prettyPrintln("hello")
    prettyPrintln(List(1, 2, 3))

    case class Person(name: String, age: Int)

    prettyPrintln(Person("John Doe", 25))

    // Try this
    case class Money(amount: Double, currency: Currency)
}
