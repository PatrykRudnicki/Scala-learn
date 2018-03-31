package functionalProgramming

import org.scalatest.{Matchers, WordSpec}

class HigherOrderFunctionsSpec extends WordSpec with Matchers {
  import HigherOrderFunctions.isSorted

  "Method isSorted" should {
    "return correct values" in {
      isSorted(Array(1, 3, 5, 7), (x: Int, y: Int) => x > y) shouldBe true

      isSorted(Array(7, 5, 1, 3), (x: Int, y: Int) => x < y) shouldBe false

      isSorted(Array("Scala", "Exercises"), (x: String, y: String) => x.length > y.length) shouldBe true
    }
  }
}
