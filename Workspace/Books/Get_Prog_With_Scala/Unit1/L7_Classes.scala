// Class sin parametros
class Robot()

// Class con parametros pero sin acceso a sus atributos
class Robot2(name: String)
// Class con parametros y acceso a atributos
class Robot3(val name: String = "Unknown") { // Con valor Default
    def welcome(n: String) = s"Welcome $n! My names is $name"
}
/// Subclases - Herencia
class ItalianRobot(name: String) extends Robot3(name) { // Pasando los parametros a la clase padre
    override def welcome(n: String) =
        s"Bienvenuto $n! Il mio name e' $name"
}

class EnglishRobot(name: String, country: String) 
    extends Robot3(name) { // Pasando los parametros a la clase padre
    override def welcome(n: String) =
        s"Welcome $n! I'm $name from the country of $country"
}

// Clase Abstracta
// usamos la palabra reservada abstract (solo se usa en clases no en metodos)
abstract class Robot4(name: String) {
    def welcome(n: String): String
}
// Implementandola
class MyRobot(name: String) extends Robot4(name) { // Se implementa como una subclase, pero hay que implementar sus metodos
    def welcome(n: String): String = 
        s"Hola $n! Soy $name"
}

object Main extends App {
    val tom = new Robot2("Tom") // Instanciando
    println(tom)
    val tom2 = new Robot3("Tom") // Instanciando
    println(tom2.name) // Accediendo a name
    println(tom2.welcome("Paul")) // Accediendo al metodo welcome
    val noName = new Robot3
    println(noName.name)

    // Subclases
    val jen = new ItalianRobot("Jen")
    println(jen.welcome("Paul")) // Accediendo a name
    val jill = new EnglishRobot("Jill", "Canada")
    println(jill.welcome("Paul")) // Accediendo a name

    // Clase abstracta
    var myrobot = new MyRobot("Atom")
    println(myrobot.welcome("Paul"))
}