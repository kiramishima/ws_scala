// Una función pura es total y no tiene side effects
// Totalidad (Totaly): Una función esta total si esta bien definida para
// todas las entradas. Debe terminar para todo valor del parametro y regresar
// una instancia que corresponda el tipo de retorno

// Side Effects: es una operación que tiene un intercambio observable con
// elementos fuera de su scope/alcance local.

// Example: Pure and Impure
def pure(name: String): String = s"Hi $name!"

def impureF(name: String): String = {
    println("...doing something here")
    s"Hi $name!"
}

// Try This
class User
def insertUser(user: User): Unit = ???
def selectUser(id: Int): User = ???

def welcome(n: String): String = s"Welcome $n!" // Pure, No Side Effect & total
def printWelcome(n: String): Unit = // Impure
    println(s"Welcome $n!")

def slowMultiplication(a : Int, b: Int): Int = { // Pure
    Thread.sleep(1000) // 1 second
    a * b
}

def saveUser(user: User): User = { // impure, side effects
    insertUser(user) // inserts in a database
    user
}

def getUser(id: Int): User = { // impure
    selectUser(id) // Searches in a database
}