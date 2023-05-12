package org.example.registrations

import doobie.implicits._
import doobie.util.ExecutionContexts
import cats._
import cats.data._
import cats.effect._
import cats.implicits._
import cats.effect.unsafe.implicits.global

object L46 extends App {
  var customerQueries = new CustomerQueries

  val allCustomers = customerQueries.all()
  println(allCustomers)

  val customer = customerQueries.nameById(1).transact(TestDatabase.xa).unsafeRunSync()
  customer match {
    case Some(name) => println(name)
    case None => println("No")
  }
  val newCustomer = customerQueries.save(Customer(id = 0, name = "Enzo")).run.transact(TestDatabase.xa).unsafeRunSync()
  println(newCustomer)

  val updateCustomer = customerQueries.updateNameById(4, Customer(id = 0, name = "Enryu")).run.transact(TestDatabase.xa).unsafeRunSync()
  println(updateCustomer)

  val allCustomers2 = customerQueries.all()
  println(allCustomers2)

  customerQueries.deleteById(4).run.transact(TestDatabase.xa).unsafeRunSync()

  val allCustomers3 = customerQueries.all()
  println(allCustomers3)
}
