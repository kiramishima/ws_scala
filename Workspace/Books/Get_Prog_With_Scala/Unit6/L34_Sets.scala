object L34 extends App {
    println(Set(3, 12.34))
    println(Set(2) + 1)
    // println(1 + Set(2))  da error no es como las listas

    // QC34.3
    def allUpper(words: Set[String]): Set[String] =
        words.map(_.toUpperCase)

    println(allUpper(Set("a", "b")))

    // QC34.5
    def crossMultiplier(groupA: Set[Int], groupB: Set[Int]): Set[Int] =
        groupA.flatMap(n => groupB.map(_ * n))

    println(crossMultiplier(Set(1, 3), Set(2, 4, 6)))

    // QC34.6
    def crossMultiplierForComprehension(groupA: Set[Int], groupB: Set[Int]): Set[Int] =
        for {
            n1 <- groupA
            n2 <- groupB
        } yield n1 * n2

    println(crossMultiplierForComprehension(Set(1, 3), Set(2, 4, 6)))

    // Try this
    case class Book(title: String, authors: List[String], genres: Set[String])

    def returnGenresByAuthor(books: Set[Book], author: String): Set[String] = {
        for {
            book <- books
            if book.authors.contains(author)
            genre <- book.genres
        } yield genre
    }
}
