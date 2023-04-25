object L28 extends App {
    def plus5(nums: List[Int]): List[Int] =
        nums.map(_ + 5)

    def triple(nums: List[Int]): List[Int] =
        nums.flatMap(n => List(n, n, n))

    def triple2(nums: List[Int]): List[Int] =
        for {
            num <- nums
            list <- List(num, num, num)
        } yield list

    // try this
    case class Person(name: String, age: Int)
    def extractNamePeople(people: List[Person]): List[String] =
        for {
            p <- people
            if p.age >= 18
        } yield p.name
    //
    println(triple(List(1,2,3)))

    println(triple2(List(1,2,3)))

    // Test Try This
    val people = List(Person(name = "Paul", age = 33), Person(name = "Olivia", age = 17), Person(name = "Martha", age = 30))
    println(extractNamePeople(people))
}
