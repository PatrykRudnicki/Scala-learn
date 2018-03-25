package scala.typeClasses

trait Model[A] {
  def add(a: A, b: A): A
}

trait Adding {
  implicit val addInts: Model[Int] = new Model[Int] {
    override def add(a: Int, b: Int): Int = a + b
  }

  implicit val addStrings: Model[String] = new Model[String] {
    override def add(a: String, b: String): String = a + b
  }

  implicit val addIntLists: Model[List[Int]] = new Model[List[Int]] {
    override def add(a: List[Int], b: List[Int]): List[Int] = a ++ b
  }

  implicit val addStringLists: Model[List[String]] = new Model[List[String]] {
    override def add(a: List[String], b: List[String]): List[String] = a ++ b
  }

  def addModels[A: Model](a: A, b: A)(implicit model: Model[A]): A =  model.add(a, b)
}

object TrainingScala extends Adding {
  println(addModels(2, 3))
  println(addModels("aa", "bb"))
  println(addModels(List(1, 2), List(3, 4)))
  println(addModels(List("a", "b"), List("c", "d")))
}