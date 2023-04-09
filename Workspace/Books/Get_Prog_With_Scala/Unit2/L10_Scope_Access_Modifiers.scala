
class Parti {
    // var attendees = 0 // public
    private var attendees = 0 //private

    def register(guests: Int) =
        attendees += guests
}

class Test {
    val configA = "I am public"
    private val configB = "I am private"
}

class Event {
    // protected
    protected def estimateCosts(attendees: Int): Double =
        if (attendees < 10) 50.00 else attendees * 12.34
}

class Party extends  Event {
    private var attendees = 0
    var cost = estimateCosts(attendees)

    def register(guests: Int) =
        attendees += guests
}

object Main extends App {
    val party1 = new Party
    party1.register(15)
    println(party1.cost)

    
    party1.register(11)
    println(party1.cost)
}