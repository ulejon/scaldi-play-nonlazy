name := "scaldi-play-nonlazy"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += "org.scaldi" %% "scaldi-play" % "0.5.8"

libraryDependencies += specs2 % Test