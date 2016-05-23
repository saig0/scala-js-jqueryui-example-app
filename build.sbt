// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "Scala.js Example with jQueryUI"

scalaVersion := "2.11.8"

version := "0.0.1"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.0"

skip in packageJSDependencies := false

//jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"

jsDependencies += "org.webjars" % "jquery" % "1.10.2" / "jquery.js"

jsDependencies += "org.webjars" % "jquery-ui" % "1.11.4" / "jquery-ui.js" dependsOn "jquery.js"