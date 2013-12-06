organization := "specs2.examples"

name := "specs-tests"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  //LOGGING
  "org.slf4j" % "jcl-over-slf4j" % "1.6.4",
  "org.slf4j" % "slf4j-api" % "1.6.4",
  "ch.qos.logback" % "logback-classic" % "1.0.9" % "runtime",
  "ch.qos.logback" % "logback-core" % "1.0.9" % "runtime",
  //SPRAY 
  "io.spray" % "spray-testkit" % "1.1-M7" % "test" withSources(),
  "io.spray" % "spray-routing" % "1.1-M7" % "compile" withSources(),
  "io.spray" % "spray-servlet" % "1.1-M7" % "compile" withSources(),
  //SPRAY-JSON - maybe better json4s-jackson
  "io.spray" %% "spray-json" % "1.2.3" % "compile" withSources(),
  "org.json4s" %% "json4s-ext" % "3.1.0" % "compile",
  //AKKA
  "com.typesafe.akka" %% "akka-actor" % "2.1.2",
  "com.typesafe.akka" %% "akka-testkit" % "2.1.2",
  "com.typesafe.akka" %% "akka-slf4j" % "2.1.2",
  //JODA
  "joda-time" % "joda-time" % "2.2",
  "org.joda" % "joda-convert" % "1.3.1",
   //CASBAH - maybe reactivemongo?
   "org.mongodb" %% "casbah" % "2.5.1",
   //SALAT - Mongo ORM 
   "com.novus" %% "salat" % "1.9.2-SNAPSHOT",
  //TESTING
    "org.specs2" %% "specs2" % "1.14" % "test",
    "junit" % "junit" % "4.11" % "test",
    "org.mockito" % "mockito-core" % "1.9.5"
  )

resolvers ++= Seq(
  ScalaToolsSnapshots,
  "Akka Repository" at "http://akka.io/repository",
  //"Sonatype OSS" at "http://oss.sonatype.org/content/repositories/releases/",
  //"Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "Web plugin repo" at "http://siasia.github.com/maven2",
  "Akka Repo" at "http://akka.io/repository",
  "repo.novus rels" at "http://repo.novus.com/releases/",
  "repo.novus snaps" at "http://repo.novus.com/snapshots/",
  "Twitter4j repo" at "http://twitter4j.org/maven2",
  "spray repo" at "http://repo.spray.io",
  "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
)
