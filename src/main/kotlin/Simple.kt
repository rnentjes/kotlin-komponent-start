import kotlinx.browser.document
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.hr
import kotlinx.html.js.onClickFunction
import nl.astraeus.komp.HtmlBuilder
import nl.astraeus.komp.Komponent
import nl.astraeus.komp.mutableCollectionState
import nl.astraeus.komp.state
import kotlin.js.Date

fun main() {
  console.log("Hello, ${greet()}")

  Komponent.create(document.body!!, TestKomponent())
}

fun greet() = "world"

class TestKomponent : Komponent() {
  var clicks: Int by state(0)
  val lines: MutableCollection<String> = mutableCollectionState(mutableListOf())

  override fun HtmlBuilder.render() {
    div {
      div {
        +"Hello Komponent!"
      }

      div {
        +"Clicks $clicks"
      }

      div {
        button {
          +"Click"
          onClickFunction = {
            clicks++
            lines.add("click $clicks at ${Date()}")
          }
        }
      }

      hr()

      for (line in lines) {
        div {
          + line
        }
      }

    }
  }
}
