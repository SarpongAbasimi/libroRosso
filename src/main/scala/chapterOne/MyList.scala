package chapterOne

sealed trait MyList[+A]
final case object MyEmptyList extends MyList[Nothing]
final case class NonEmptyList[A](theHead: A, theTail: MyList[A]) extends MyList[A]

/*** Why should NonEmpty be covariant in A***/
//final case class NonEmptyList[+A](theHead: A, theTail: MyList[A]) extends MyList[A]

sealed trait Animal
final case object Dog extends Animal
final case class Bird(name: String) extends  Animal

// Just a random thought of how the apply method would be
// Using this we are ble to write MyList[Int](1,2,3,4)
object MyList {
  def apply[A](aValue: A*): MyList[A] = {
    if(aValue.isEmpty) MyEmptyList
    else new NonEmptyList[A](aValue.head, apply(aValue.tail: _*))
  }

}
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