object AnonymousFunction extends App {
    // def hello(n: String): String = s"Hello, $n!"
    // val hello = (n: String) => s"Hello, $n!"
    // val hello: (String) => String = (n: String) => s"Hello, $n!"
    val hello: (String) => String = { s"Hello, ${_}!" }

    println(hello("Prime Kira"))
}