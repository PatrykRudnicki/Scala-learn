package functionalProgramming

object Currying {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)

  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)

  def f(a: Int, b: Int): Int = a + b

  def g(a: Int)(b: Int): Int = a + b
}
