name := "FinancePR"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor" % "2.3.9",
                            "io.spray" %% "spray-can" % "1.3.3",
                            "io.spray" %% "spray-routing" % "1.3.3",
                            "io.spray" %% "spray-json" % "1.3.1",
                            "ch.qos.logback" % "logback-classic" % "1.1.3")