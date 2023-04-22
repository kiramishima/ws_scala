package org.example.game.entities

sealed trait Symbol {
    protected def beats: List[Symbol]

    def wins(other: Symbol): Boolean =
        beats.contains(other)
}

// Rules:
// Rock aplasta a Lizard
// Rock destruye a Scissors
case object Rock extends Symbol {
    protected val beats = List(Lizard, Scissors)
}

// Rules:
// Paper cubre a Rock
// Paper desaprueba a Spock
case object Paper extends Symbol {
    protected val beats = List(Rock, Spock)
}

// Rules:
// Scissors corta a Paper
// Scissors decapita a Lizard
case object Scissors extends Symbol {
    protected val beats = List(Paper, Lizard)
}

// Rules:
// Lizard envenena a Spock
// Lizard come a Paper
case object Lizard extends Symbol {
    protected val beats = List(Spock, Paper)
}

// Rules:
// Spock aplasta a Scissors
// Spock vaporiza a Rock
case object Spock extends Symbol {
    protected val beats = List(Scissors, Rock)
}


object Symbol {
    def fromString(text: String): Symbol =
        text.trim.toLowerCase match {
            case "rock" => Rock
            case "paper" => Paper
            case "scissors" => Scissors
            case "lizard" => Lizard
            case "spock" => Spock
            case unknown =>
                val errorMsg = s"Unknown symbol $unknown." +
                "Please pick a valid symbol [Rock, Paper, Scissors, Lizard, Spock]"
                throw new IllegalArgumentException(errorMsg)
        }
}