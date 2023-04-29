name := "movies-dataset-app"
version := "0.1"
scalaVersion := "3.2.2"

// resolvers += "ivy2 cache" at "/home/user/.ivy2/cache"
//  append http4s 
val http4sVersion = "0.23.18"
val CirceVersion = "0.14.1"
val ScalaCsvVersion = "1.3.10"
val LogbackVersion = "1.4.6"

libraryDependencies ++= List(
    "org.http4s" %% "http4s-ember-client" % http4sVersion,
    "org.http4s" %% "http4s-ember-server" % http4sVersion,
    "org.http4s" %% "http4s-dsl"          % http4sVersion,
    "io.circe" %% "circe-core" % CirceVersion,
    "io.circe" %% "circe-generic" % CirceVersion,
    "io.circe" %% "circe-parser" % CirceVersion,
    "com.github.tototoshi" %% "scala-csv" % ScalaCsvVersion,
    "ch.qos.logback"  %  "logback-classic"     % LogbackVersion
)