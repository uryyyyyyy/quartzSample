name := """quartzSample-spring"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
	"junit" % "junit" % "4.12" % "test",
	"org.quartz-scheduler" % "quartz" % "2.2.1",
	"org.springframework" % "spring-context-support" % "4.1.7.RELEASE",
	"commons-logging" % "commons-logging" % "1.2",
	"org.springframework" % "spring-tx" % "4.1.7.RELEASE"
)
