object L30 extends App {
    case class Contact(name: String,
                       surname: String,
                       numbers: List[ContactNumber],
                       company: Option[String],
                       email: Option[String])

    sealed trait Label
    case object Work extends Label
    case object Home extends Label

    case class ContactNumber(number: String, label: Label)

    def safeApply[A](list: List[A], n:Int): Option[A] =
        if (0 < n && n < list.size) Some(list.apply(n))
        else None

    def findByCompany(addressBook: List[Contact], company: String): Option[Contact] =
        addressBook.find(_.company.exists(_.equalsIgnoreCase(company)))
    
    def topContact(addressBook: List[Contact]): Contact =
        addressBook.max // throws Error because max dont work, substitute by maxby 
}