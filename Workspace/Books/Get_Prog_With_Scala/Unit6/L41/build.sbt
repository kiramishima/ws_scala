name := "library-app"

version := "0.1"

scalaVersion := "3.2.2"

val ScalaCsvVersion = "1.3.10"
val LogbackVersion = "1.4.6"

libraryDependencies ++= List(
    "com.github.tototoshi" %% "scala-csv" % ScalaCsvVersion,
    "ch.qos.logback"  %  "logback-classic"     % LogbackVersion
)