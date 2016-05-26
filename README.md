scala-js-jqueryui-example-app
=============================

an example app with scala.js, scala.js-jQuery adapter and jQueryUI

## Get started

To get started, open `sbt` in this example project, and issue the task
`~fastOptJS`.
You can now open `target\scala-2.11\index-dev.html` in your favorite Web browser!

## The optimized version

Instead of running `fastOptJS`, you can also run `fullOptJS` to generate
a much more compact version of the JavaScript code. While `target\scala-2.11\index-dev.html`
refers to the JavaScript emitted by `fastOptJS`, `target\scala-2.11\index.html` refers to the
optimized JavaScript emitted by `fullOptJS`.
