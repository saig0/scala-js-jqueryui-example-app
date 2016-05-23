package de.scalajs.example

import scala.scalajs.js
import js.Dynamic.literal
import org.scalajs.jquery._
import de.scalajs.jqueryui.JQueryUi._
import de.scalajs.jqueryui._

import scala.scalajs.js.annotation.JSExport
import scala.util.Random

@JSExport(name="DragAndDropExample")
object DragAndDropExample {

  var correctCards = 0

  @JSExport
  def main(): Unit = {
    // Restart game with button
    jQuery("#resetButton").click((_: JQueryEventObject) => main())

    // Hide the success message
    jQuery("#successMessage").hide()
    jQuery("#successMessage").css(literal(
      left = "580px",
      top = "250px",
      width = 0,
      height = 0))

    // Reset the game
    correctCards = 0
    jQuery("#cardPile").html("")
    jQuery("#cardSlots").html("")

    // Create the pile of shuffled cards
    val numbers = Random.shuffle(1 to 10)

    numbers foreach { number =>
      val id = s"card$number"
      jQuery(s"<div id='$id'>$number</div>").data("number", number).appendTo("#cardPile").draggable(literal(
        containment = "#content",
        stack = "#cardPile div",
        cursor = "move",
        revert = true))
    }

    // Create the card slots
    val words = List("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
    words foreach { word =>
      val number = words.indexOf(word) + 1
      jQuery(s"<div>$word</div>").data("number", number).appendTo("#cardSlots").droppable(literal(
        accept = "#cardPile div",
        hoverClass = "hovered",
        drop = handleCardDrop))
    }

  }

  private def handleCardDrop = (event: JQueryEventObject, ui: JQueryUiDropObject) => {
    // is equals to $(this)
    val slot = jQuery(event.target)
    val card = ui.draggable

    val slotNumber = slot.data("number")
    val cardNumber = card.data("number")

    // If the card was dropped to the correct slot,
    // change the card colour, position it directly
    // on top of the slot, and prevent it being dragged
    // again
    if (slotNumber == cardNumber) {
      card.addClass("correct")
      card.draggable("disable")
      slot.droppable("disable")
      card.position(literal(
        of = slot,
        my = "left top",
        at = "left top"))
      card.draggable(literal(
        revert = false))
      correctCards += 1
    }

    // If all the cards have been placed correctly then display a message
    // and reset the cards for another go
    if (correctCards == 10) {
      jQuery("#successMessage").show()
      jQuery("#successMessage").animate(literal(
        left = "380px",
        top = "200px",
        width = "400px",
        height = "100px",
        opacity = 1))
    }
  }
}
