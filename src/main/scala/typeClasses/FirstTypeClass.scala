package scala.typeClasses

trait Eq[A] {
  def areEquals(a: A, b: A): Boolean
}

// To third method
object Eq {
  def apply[A](implicit eq: Eq[A]): Eq[A] = eq
}

object FirstTypeClass {
  def moduloEq(divisor: Int): Eq[Int] = new Eq[Int] {
    override def areEquals(a: Int, b: Int) = a % divisor == b % divisor
  }

  // How can you assign function (Int, Int) => Boolean to reference with type Eq[Int]?! This thing is possible thanks
  // to Java 8 feature called Single Abstract Method type of interface. We can do such a thing when we have only
  // one abstract method in our trait.
  def moduloEq: Eq[Int] = (a: Int, b: Int) => a % 5 == b % 5



  implicit val modulo5Eq: Eq[Int] = moduloEq(5)

  // First method
//  def pairEquals[A](a: A, b: A)(implicit eq: Eq[A]): Option[(A,A)] = {
//    if(eq.areEquals(a,b)) Some((a,b)) else None
//  }

  // Second method
//  def pairEquals[A: Eq](a: A, b: A): Option[(A, A)] = {
//    if(implicitly[Eq[A]].areEquals(a,b)) Some((a,b)) else None
//  }

  //Third method
//  def pairEquals[A: Eq](a: A, b: A): Option[(A, A)] = {
//    if(Eq[A].areEquals(a, b)) Some((a, b)) else None
//  }

  println(pairEquals(2,7))
  println(pairEquals(2,3))

  println(moduloEq(5).areEquals(2,7))



  //Forth solution
  implicit class EqSyntax[A: Eq](a: A) {
    def ===(b: A): Boolean = Eq[A].areEquals(a, b)
  }

  def pairEquals[A: Eq](a: A, b: A): Option[(A, A)] = {
    if(a === b) Some((a, b)) else None
  }

  //sorted[B >: A](implicit ord: math.Ordering[B]): List[A]
  //Type class instance will be searched in:
  //* Ordering companion object
  //* List companion object
  //* B companion object (which can be also A companion object because of existence of lower bounds definition)
}


/*
import simulacrum._
@typeclass trait Eq[A] {
 @op(“===”) def areEquals(a: A, b: A): Boolean
}
 */