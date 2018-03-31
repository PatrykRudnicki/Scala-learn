package functionalProgramming

import org.scalatest.{Matchers, WordSpec}

class CurryingSpec extends WordSpec with Matchers {
  import Currying._

  "Method curry" should {
    "return correct values" in {
      curry(f)(1)(1) == f(1, 1) shouldBe true

      curry(f)(1)(1) == g(1)(1) shouldBe true
    }
  }

  "Method uncurry" should {
    "return correct values" in {
      uncurry(g)(1, 1) == g(1)(1) shouldBe true

      uncurry(g)(1, 1) == f(1, 1) shouldBe true
    }
  }
}
