package org.example.registrations

import doobie.*
import doobie.implicits.*
import cats.effect.IO
import scala.concurrent.ExecutionContext
import cats.effect.unsafe.implicits.global

case class Customer(id: Int, name: String)
case class CustomerQueries() {
  import TestDatabase.xa
  private val customers = {
    sql"SELECT * FROM customer"
      .query[Customer]
      .to[List]
  }

  def all() = {
    customers.transact(xa).unsafeRunSync()
  }

  def nameById(id: Int) = {
    sql"SELECT name FROM customer WHERE id = $id".query[String].option
  }

  def save(customer: Customer) =
    sql"INSERT INTO customer(name) VALUES (${customer.name})".update

  def updateNameById(id: Int, customer: Customer) =
    sql"UPDATE customer SET name = ${customer.name} WHERE id = $id".update

  def deleteById(id: Int) =
    sql"DELETE FROM customer WHERE id = $id".update
}
