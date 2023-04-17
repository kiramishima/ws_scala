package org.example.time

import cats.effect.*
import org.http4s.dsl.io.*
import cats.syntax.all.*
import com.comcast.ip4s.*
import org.http4s.ember.server.*
import org.http4s.server.Router
import scala.concurrent.duration.*
import org.http4s.implicits.*

object TimeApp extends IOApp {
    private val httpApp = Router(
        "/" -> new TimeApi().service
    ).orNotFound

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