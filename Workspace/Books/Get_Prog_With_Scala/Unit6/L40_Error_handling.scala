package L40

import java.time.LocalDate
import scala.util.{Failure, Success, Try}

object L40 extends App {
    case class Student(id: Int, name: String, topics: Set[String])
    case class ExamSession(name: String, localDate: LocalDate, topic: String)

    case class Registration(studentId: Int, examSession:ExamSession, localDate: LocalDate = LocalDate.now())

    // 40.1
    def register(student: Student, examSession: ExamSession): Try[Registration] = {
        if (student.topics.contains(examSession.topic))
            Success(Registration(student.id, examSession))
        else
            Failure(new IllegalStateException(
                s"Student ${student.id} is missing topic ${examSession.topic}"
            ))
    }
    // 40.4 Modificacion aplicando Try.apply
    def register2(student: Student, examSession: ExamSession): Try[Registration] = {
        Try {
            if (student.topics.contains(examSession.topic))
                Registration(student.id, examSession)
            else
                throw new IllegalStateException(
                    s"Student ${student.id} is missing topic ${examSession.topic}")
        }
    }

    // QC 40.1
    def toTry[T](either: Either[Throwable, T]): Try[T] =
        either match {
            case Left(value) => Failure(value)
            case Right(value) => Success(value)
        }
    // QC 40.2
    def toEither[T](tryT: Try[T]): Either[Throwable, T] =
        tryT match {
            case Success(value) => Right(value)
            case Failure(value) => Left(value)
        }
    // 40.6 Uso de Map
    def getRegistrationDate(registration: Try[Registration]): Try[LocalDate] =
        registration.map(_.localDate)
    // QC 40.3
    def toFloat(d: Try[Double]): Try[Float] =
        d.map(_.toFloat)

    // 40.3.2 Ejemplo con flatten
    def getNextExamSession(topic: String): Try[ExamSession] = ???

    // Composicion
    def registerForNextExamSession(student: Student, topic: String): Try[Registration] =
        getNextExamSession(topic).map { examSession =>
            register(student, examSession)
        }.flatten

    // QC 40.4
    def superFlatten[T](tryT: Try[Try[Try[T]]]): Try[T] =
        tryT.flatten.flatten

    // 40.8 Uso de flatmap
    def registerForNextExamSession2(student: Student, topic: String): Try[Registration] =
        getNextExamSession(topic).flatMap { examSession =>
            register(student, examSession)
        }
    // QC 40.5
    def findStudent(id: Int): Try[Student] = ???

    def findStudent2(id: String): Try[Student] =
        Try(id.toInt).flatMap(findStudent)

    // 40.9 Uso de for-comprehension
    def registerForNextExamSession3(student: Student, topic: String): Try[Registration] =
        for {
            examSession <- getNextExamSession(topic)
            registration <- register(student, examSession)
        } yield registration

    // QC 40.6
    def findStudent3(id: String): Try[Student] =
        for {
            n <- Try(id.toInt)
            student <- findStudent(n)
        } yield student

    // QC 40.7
    def toSafeBoolean(text: String): Boolean =
        Try(text.toBoolean).getOrElse(false)

    // Try this
    case class Person(age: Int, name: String)

    def textToPerson(text: String): Try[Person] = {
        Try {
            val arr = text.split(",").toList
            val List(age, name) = arr
            Person(age.toInt, name)
        }
    }

    println(textToPerson("45, Ron"))
    println(textToPerson("34, Paul"))
    println(textToPerson("Invalid text"))
}
