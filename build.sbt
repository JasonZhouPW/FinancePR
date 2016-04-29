name := "FinancePR"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor" % "2.3.9",
                            "io.spray" %% "spray-can" % "1.3.3",
                            "io.spray" %% "spray-routing" % "1.3.3",
                            "io.spray" %% "spray-json" % "1.3.1",
                            "nu.validator.htmlparser" % "htmlparser" % "1.2.1",
                            "net.databinder" % "dispatch-jsoup_2.9.1" % "0.8.9",
                            "ch.qos.logback" % "logback-classic" % "1.1.3")