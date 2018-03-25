package training

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object TestObject {
  var value: String = "Initial value"
}

object SecondTestObject {
  var value: String = "Initial value"
}

object TryBlock extends App {

  def methodOne(): Unit = println("First method")

  def methodTwo(): Unit = {
    println("Second method with error")
    TestObject.value = "Changed value in second method"
    throw new RuntimeException()
    TestObject.value = "Value after exception"
  }

  def methodThree(): Unit = {
    TestObject.value = "Change in method three"
    println("Method three")
  }

  println(TestObject.value)

  try {
    methodOne()
    methodTwo()
    methodThree()
  } catch {
    case _: RuntimeException => println("Handle exception")
  }

  println(TestObject.value)

  println("For comprehension")

  def firstMethod(): Future[Unit] = Future.successful(println("First method for second object"))

  def secondMethod(): Future[Unit] = {
    println("Second method for second object with error")
    SecondTestObject.value = "Changed value in second method"
    throw new RuntimeException()
    Future.successful(SecondTestObject.value = "Value after exception")
  }

  def thirdMethod(): Future[Unit] = {
    SecondTestObject.value = "Changed in method three"
    println("Third method")
    Future.successful()
  }

  println(SecondTestObject.value)

  for {
    _ <- firstMethod()
    _ <- secondMethod()
    _ <- thirdMethod()
  } yield println("This is the end")

  println("End value: " + SecondTestObject.value)
}
