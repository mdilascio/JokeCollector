name := "JokeCollector"
organization := "man4rky"

version := "1.0"

scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV       = "2.4.4"
  Seq(
    "org.scala-lang" % "scala-reflect" % "2.11.8",
    "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4",
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "com.github.swagger-akka-http" %% "swagger-akka-http" % "0.6.2",
    "net.codingwell" %% "scala-guice" % "4.0.1"
  )
}
