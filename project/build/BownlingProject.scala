import sbt._

class BowlingProject(info: ProjectInfo) extends DefaultProject(info){

  val specs = "org.scala-tools.testing" % "specs_2.8.1" % "1.6.7" % "test"
  val scalatest = "org.scalatest" % "scalatest" % "1.2" %  "test"
}
