package org.example.registrations

import doobie._
import doobie.implicits._
import cats.effect.IO
import scala.concurrent.ExecutionContext

object TestDatabase {
  // lo comentamos porque no usaremos docker xD
  // private val psqlServer = new PostgreSQL("init.sql") // Iniciara el servidor de pruebas
  val xa = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", "jdbc:postgresql://192.168.100.47/scala_customers", "postgres", "123456"
  )
}
