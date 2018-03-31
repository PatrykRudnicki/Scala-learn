package functionalProgramming

import org.scalatest.{Matchers, WordSpec}

class TailRecursiveProgrammingSpec extends WordSpec with Matchers {
  import TailRecursiveFunctions.fib

  "Method for Fibonacci numbers" should {
    "returns 5 for 5" in {
      fib(5) shouldBe 5
    }

    "returns 144 for 12" in {
      fib(12) shouldBe 144
    }
  }
}
