object L35 extends App {
    //QC35.2
    def sumInRange(numbers: Set[Double]): Double =
        numbers.filter { n => n > 0 && n < 100 }.sum

    val nums = Set[Double](0.5, -1, 50.5, 99, 100)
    println(sumInRange(nums))

    // Try this
    case class Student(id: Int, name: String, topics: Set[String])

    val studentsList = Set(
        Student(1, "Paul", topics = Set("Math", "French")),
        Student(2, "Zura", topics = Set("Math", "Arts")),
        Student(3, "Veronica", topics = Set("Arts", "English")),
        Student(4, "Eleonora", topics = Set("Italian", "French", "English")))

    val topics = Set("Math", "French")

    def filterByTopics(students: Set[Student], topics: Set[String]): Set[Student] = {
        students.filter { student =>
            val matchingTopics = student.topics.intersect(topics)
            // student.topics intersect topics
            matchingTopics.nonEmpty
        }
    }

    println(filterByTopics(studentsList, topics))
}
