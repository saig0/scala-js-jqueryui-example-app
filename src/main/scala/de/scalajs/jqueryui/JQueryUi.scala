package de.scalajs.jqueryui

import scala.scalajs.js
import org.scalajs.jquery._

import scala.language.implicitConversions

object JQueryUi {
  implicit def jquery2ui(jquery: JQuery): JQueryUi =
    jquery.asInstanceOf[JQueryUi]
}

@js.native
trait JQueryUi extends JQuery {
  def draggable(options: js.Any): this.type = js.native

  def droppable(options: js.Any): this.type = js.native

  def position(options: js.Any): this.type = js.native
}

@js.native
trait JQueryUiObject extends js.Object {
  var helper: JQueryUi = js.native
  var position: JQueryUiCoordinate = js.native
  var offset: JQueryUiCoordinate = js.native
}

@js.native
trait JQueryUiDropObject extends JQueryUiObject {
  var draggable: JQuery = js.native
}

@js.native
trait JQueryUiCoordinate extends js.Object {
  var left: Double = js.native
  var top: Double = js.native
}