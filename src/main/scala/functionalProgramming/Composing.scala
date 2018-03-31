package functionalProgramming

object Composing {
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a))

  def f(b: Int): Int = b / 2

  def g(a: Int): Int = a + 2
}
