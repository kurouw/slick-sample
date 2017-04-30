name := "lick-sample"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.0-M2",
  "com.h2database" % "h2" % "1.4.181",
  "com.mchange" % "c3p0" % "0.9.5.1"
)
