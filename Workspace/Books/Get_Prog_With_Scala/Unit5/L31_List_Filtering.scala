object L32 extends App {
    case class Contact(name: String,
                       surname: String,
                       numbers: List[ContactNumber],
                       company: Option[String],
                       email: Option[String])

    sealed trait Label
    case object Work extends Label
    case object Home extends Label

    case class ContactNumber(number: String, label: Label)

    def firstN(addressBook: List[Contact], n: Int): List[Contact] =
        addressBook.take(n)

    // QC 
    def paginate(data: List[String], pageN: Int, pageSize: Int): List[String] = {
        val skip = (pageN - 1) * pageSize
        data.drop(skip).take(pageSize)
    }

    def fromCompany(addressBook: List[Contact], corp: String): List[Contact] =
        addressBook.filter(contact =>
            contact.company.exists(_.equalsIgnoreCase(corp))
        )
    
    // uso de distinct
    def removeDuplicates(addressBook: List[Contact]): List[Contact] =
        addressBook.distinct

    // Try this
    sealed trait Genre
    case object Action extends Genre
    case object Comic extends Genre
    case object Drama extends Genre

    case class Book(title: String, authors: List[String], genre: Genre)

    val books = List(
        Book("B1", List("King", "Sfregola", "King"), Drama),
        Book("B2", List("Mex"), Action),
        Book("B3", List("Queen", "Sfregola"), Action),
        Book("B1", List("King", "Sfregola", "King"), Drama),
        Book("B5", List("Potter"), Drama)
    )

    def removeDuplicatesBooks(books: List[Book]): List[Book] =
        books.filter(_.genre == Drama).distinct

    def removeDuplicatesAuthors(books: List[Book]): List[String] =
        books.filter(_.genre == Drama).flatMap(_.authors).distinct

    println(removeDuplicatesBooks(books))
    println(removeDuplicatesAuthors(books))
}
