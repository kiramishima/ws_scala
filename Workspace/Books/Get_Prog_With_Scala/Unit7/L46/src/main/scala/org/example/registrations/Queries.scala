package org.example.registrations

import scala.concurrent.{ExecutionContext, Future}
import doobie.*
import doobie.implicits.*

class Queries {

  def testConnection()(implicit ec: ExecutionContext) = sql"SELECT 1 + 1".query[Int].unique
  
}
