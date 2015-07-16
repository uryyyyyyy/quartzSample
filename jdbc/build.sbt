name := """quartzSample"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "junit"             % "junit"           % "4.12"  % "test",
  "org.quartz-scheduler" % "quartz" % "2.2.1",
	"mysql" % "mysql-connector-java" % "5.1.36"
)
