package functionalProgramming

import org.scalatest.{Matchers, WordSpec}

class ComposingSpec extends WordSpec with Matchers{
  import Composing._

  "Method compose" should {
    "return correct values" in {
      compose(f, g)(0) == compose(g, f)(0) shouldBe false

      compose(f, g)(2) shouldBe 2

      compose(g, f)(2) shouldBe 3
    }
  }

}
