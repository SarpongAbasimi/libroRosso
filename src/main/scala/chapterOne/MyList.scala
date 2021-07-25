package chapterOne

sealed trait MyList[+A]
final case object MyEmptyList extends MyList[Nothing]
final case class NonEmptyList[A](theHead: A, theTail: MyList[A]) extends MyList[A]

/*** Why should NonEmpty be covariant in A***/
//final case class NonEmptyList[+A](theHead: A, theTail: MyList[A]) extends MyList[A]

sealed trait Animal
final case object Dog extends Animal
final case class Bird(name: String) extends  Animal

object MyListImplementation {
  def sum(aType: MyList[Int]):Int =  aType match {
    case MyEmptyList => 0
    case NonEmptyList(theyHead, theTail) => theyHead + sum(theTail)
  }


  def main(args: Array[String]): Unit = {
    val result = sum(NonEmptyList(100, NonEmptyList(2, MyEmptyList)))
    val animalOne = Dog
    val animalTwo = Bird("Yellow hey")

    val myNonEmptyListOfAnimal : MyList[Animal] = NonEmptyList[Animal](
      animalOne ,
      NonEmptyList(animalTwo, MyEmptyList)
    )

    println(myNonEmptyListOfAnimal)
  }
}