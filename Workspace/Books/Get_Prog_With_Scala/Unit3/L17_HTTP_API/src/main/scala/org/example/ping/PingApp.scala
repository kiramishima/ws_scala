package org.example.ping

import cats.effect._
import org.http4s.dsl.io._
import cats.syntax.all._
import com.comcast.ip4s._
import org.http4s.ember.server._
import org.http4s.server.Router
import scala.concurrent.duration._
import org.http4s.implicits.* // En Scala 2.x es con _ en lugar de *

object PingApp extends IOApp {
    private val httpApp = Router(
        "/" -> new PingApi().routes
    ).orNotFound // orNotFound viene de implicits

    override def run(args: List[String]): IO[ExitCode] =
        EmberServerBuilder
            .default[IO]
            .withHost(ipv4"0.0.0.0")
            .withPort(port"8080")
            .withHttpApp(httpApp)
            .build
            .use(_ => IO.never)
            .as(ExitCode.Success)
}
