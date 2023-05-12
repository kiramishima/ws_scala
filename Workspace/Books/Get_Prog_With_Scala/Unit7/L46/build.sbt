val scala3Version = "3.2.2"
val quillVersion  = "4.6.0.1"
val postgresqlVersion = "42.5.4"
val LogbackVersion = "1.4.6"
val pureConfigVersion = "0.17.3"
val dobbieVersion = "1.0.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "L46-Database-with-Quill",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "ch.qos.logback"  %  "logback-classic"     % LogbackVersion,
      "org.tpolecat" %% "doobie-core"      % dobbieVersion,
      "org.tpolecat" %% "doobie-hikari"    % dobbieVersion,
      "org.tpolecat" %% "doobie-postgres"  % dobbieVersion,
      "org.testcontainers" % "postgresql" % "1.17.6",
      "org.scalameta" %% "munit" % "0.7.29" % Test
    )
  )
