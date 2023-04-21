package L24
// for-comprehesion es azucar sintactica para maps & flatmap anidados

case class Person(name: String,
                  age: Int,
                  drivingLicense: Option[String])

case class Car(model: String,
               owner: Option[Person],
               registrationPlate: Option[String])

// for-comprehesion example
def ownerDrivingLicenseFC(optCar: Option[Car]): Option[String] =
    for {
        car <- optCar
        person <- car.owner
        drivingLicense <- person.drivingLicense
    } yield drivingLicense

def getDrivingLicenseByOwnerNameFC(optCar: Option[Car], ownerName: String): Option[String] =
    for {
        car <- optCar
        person <- car.owner
        if person.name == ownerName
        drivingLicense <- person.drivingLicense
    } yield drivingLicense.toUpperCase

// Modificación del usado en L23
def ownerBelowAge(car: Car, age: Int): Option[String] =
    for {
        person <- car.owner
        if person.age < age
    } yield person.name

// QC
def carWithLicensedOwner(optCar: Option[Car]): Option[Car] =
    for {
        car <- optCar
        owner <- car.owner
        if owner.drivingLicense.isDefined
    } yield car
    // El libro
    // optCar.find { car => 
    //    car.owner.flatMap(_.drivingLicense).isDefined
    // }

object L24 extends App {
    // Try this
    case class Assistant(id: long, name: String)
    case class Professor(id: long, name: String, assistant: Option[Assistant])
    case class Student(id: long, name: String, tutor: Option[Professor])

    def retriveProfesorNameOfStudent(optStudent: Option[Student]): Option[String] =
        for {
            student <- optStudent
            tutor <- student.tutor
            tutorName <- tutor.name
        } yield tutorName // o directo evitar tutorName y colocar tutor.name

    def findTutorAssistantId(optStudent: Option[Student]): Option[Long] =
        for {
            student <- optStudent
            tutor <- student.tutor
            assistant <- tutor.assistant
        } yield assistant.id

    def retrieveStudentWithTutorId(optStudent: Option[Student], id: Long): Option[Student] =
        for {
            student <- optStudent
            tutor <- student.tutor
            if tutor.id == id
            student <- student
        } yield student
        // El Libro sin Option[Student]
        // if student.tutor.exists(_.id == id) Some student
        // else None
}