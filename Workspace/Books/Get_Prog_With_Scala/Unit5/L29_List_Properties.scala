object L29 extends App {
    class A(i: Int)
    case class B(i: Int)

    println(List("Welcome", "to", "Scala").contains("scala"))
    println(List("Welcome", "to", "Scala").exists(_.endsWith("me")))
    println(List("Welcome", "to", "Scala").count(_.contains("o")))
    println(List(new A(1)).contains(new A(1)))
    println(List(new B(1)).contains(new B(1)))

    // try this
    println("============")
    case class Person(name: String, age: Int)

    val people = List(Person(name = "Paul", age = 33), Person(name = "Oliver", age = 17), Person(name = "Martha", age = 30))
    println(people.map(_.name.contains("Martha")))
    println(people.exists(_.age > 20))
    println(people.count(_.name.contains("a")))
    println(people.contains(Person(name = "Martha", age = 30)))
}
