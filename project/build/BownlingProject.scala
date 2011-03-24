import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info){

  /*
  val slf4j_version = "1.6.1"
  val slf4j = "org.slf4j" % "slf4j-api" % slf4j_version
  val slf4j_log4j14 = "org.slf4j" % "slf4j-log4j12" % slf4j_version
      */
  val specs = "org.scala-tools.testing" % "specs_2.8.1" % "1.6.7" % "test"
  val scalatest = "org.scalatest" % "scalatest" % "1.2" %  "test"
}
