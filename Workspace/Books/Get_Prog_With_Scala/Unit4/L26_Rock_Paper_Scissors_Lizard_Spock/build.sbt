name := "rock-paper,scissors-lizard-spock-app"
version := "0.1"
scalaVersion := "3.2.2"

// resolvers += "ivy2 cache" at "/home/user/.ivy2/cache"
//  append http4s 
val http4sVersion = "0.23.18"

libraryDependencies ++= List(
    "org.http4s" %% "http4s-ember-client" % http4sVersion,
    "org.http4s" %% "http4s-ember-server" % http4sVersion,
    "org.http4s" %% "http4s-dsl"          % http4sVersion,
    "ch.qos.logback" % "logback-classic" % "1.4.6",
)