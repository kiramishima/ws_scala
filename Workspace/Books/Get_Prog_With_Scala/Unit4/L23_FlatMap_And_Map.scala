package L23

case class Person(name: String,
                  age: Int,
                  drivingLicense: Option[String])

case class Car(model: String,
               owner: Option[Person],
               registrationPlate: Option[String])

def ownerName(car: Car): Option[String] =
        car.owner match {
            case Some(p) => Some(p.name)
            case None => None
        }

def ownerNameWithMap(car: Car): Option[String] =
        car.owner.map(p => p.name)

// QC
def extractRegistrationPlate(car: Car): Option[String] =
    car.registrationPlate.map(p => p.toUpperCase)
    // car.registrationPlate.map(_.toUpperCase) <- Solución del libro XD

def superFlatten(opt: Option[Option[Option[String]]]): Option[String] = 
    opt.flatten.flatten

def ownerBelowAge(car: Car, age: Int): Option[String] =
    car.owner.flatMap(p => p.age match {
        case a: Int if a < age => Some(p.name)
        case _ => None
    })
/* Solucion del libro
def ownerBelowAge(car: Car, age: Int): Option[String] =
    car.owner.flatMap(p =>
        if (p.age < age) Some(p.name)
        else None
*/
// flatten
// sin flatten
def ownerDrivingLicense(car: Car): Option[Option[String]] =
        car.owner.map(_.drivingLicense)

// con flatten, actua cuando ve un Option[Option[A]] y regresa Option[A]
def ownerDrivingLicenseWithFlatten(car: Car): Option[String] =
        car.owner.map(_.drivingLicense).flatten

// flatMap
def ownerDrivingLicenseWithFlatMap(car: Car): Option[String] =
        car.owner.flatMap(_.drivingLicense)

object L23 extends App {
    // Try this
    case class Assistant(id: long, name: String)
    case class Professor(id: long, name: String, assistant: Option[Assistant])
    case class Student(id: long, name: String, tutor: Option[Professor])

    def retriveProfesorNameOfStudent(student: Student): Option[String] =
        student.tutor.map(_.name)

    def findTutorAssistantId(student: Student): Option[Long] =
        student.tutor.flatMap { prof =>
            prof.assistant.map(_.id)
        }

    def retrieveStudentWithTutorId(student: Student, id: Long): Option[Student] =
        student.tutor.flatMap { professor =>
            if (professor.id == id) Some(student)
            else None
        }
    //
    val car = new Car(model = "2023", owner = None, registrationPlate = None)
    val p = Person(name = "Paul", age = 33, drivingLicense = Some("MISHIMA"))
    val car2 = new Car(model = "2023", owner = Some(p), registrationPlate = Some("DEVIL"))

    println(ownerName(car))
    println(ownerNameWithMap(car2))
    println(extractRegistrationPlate(car2))

}
