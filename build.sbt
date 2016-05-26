// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "Scala.js Example with jQueryUI"

scalaVersion := "2.11.8"

version := "1.0.0"


def generateIndexTask(index: String, suffix: String) = Def.task {
  val source = baseDirectory.value / "index-template.html"
  val target = (crossTarget in Compile).value / index
  val log = streams.value.log
  IO.writeLines(target,
    IO.readLines(source).map {
      line => line.replace("{{opt}}", suffix)
    }
  )

  log.info(s"Generate $index with suffix $suffix")
}

def copyCss = Def.task {
  val source = baseDirectory.value / "style.css"
  val target = (crossTarget in Compile).value / "style.css"
  IO.writeLines(target,
    IO.readLines(source)
  )

}

Seq(
  (fastOptJS in Compile, "index-dev.html", "fastOpt"),
  (fullOptJS in Compile, "index.html", "opt")
).map {
  case (task, indexHtml, postfix) =>
    task <<= task.dependsOn(generateIndexTask(indexHtml, postfix), copyCss)
}

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.0"

skip in packageJSDependencies := false

persistLauncher in Compile := true

persistLauncher in Test := false

// jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"

jsDependencies += "org.webjars" % "jquery" % "1.10.2" / "jquery.js"

jsDependencies += "org.webjars" % "jquery-ui" % "1.11.4" / "jquery-ui.js" dependsOn "jquery.js"