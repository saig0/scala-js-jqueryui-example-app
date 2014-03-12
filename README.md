scala-js-jqueryui-example-app
=============================

an example app with scala.js, scala.js-jQuery adapter and jQueryUI

## Get started

To get started, open `sbt` in this example project, and issue the task
`~packageJS`.
You can now open `index-dev.html` in your favorite Web browser!

## The optimized version

Instead of running `packageJS`, you can also run `optimizeJS` to generate
a much more compact version of the JavaScript code. While `index-dev.html`
refers to the JavaScript emitted by `packageJS`, `index.html` refers to the
optimized JavaScript emitted by `optimizeJS`.
