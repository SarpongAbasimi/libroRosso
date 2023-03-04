package tpclasses

import scala.language.implicitConversions
import cats.{Functor, Id, Monad, Monoid}
import cats.implicits._

trait Printable[A]{
  def format(value: A)
}

trait OwnMonoid[A] {
  def combine(valueOne: A, valueTwo: A): A
  def identity: A
}


object MonoidInstance {
  implicit val intInstance: OwnMonoid[Int] = new OwnMonoid[Int] {
    def combine(valueOne: Int, valueTwo: Int): Int =
      valueOne + valueTwo
    override def identity: Int = 0
  }
}

final case class Cat(name:String, age: Int, colour: String)


object PrintableInstances{
  implicit val catsInstance: Printable[Cat] = new Printable[Cat] {
    def format(value: Cat): Unit =
      println(
        s"${value.name} " +
          s"is a ${value.age} " +
          s"year-old ${value.colour} cat."
      )
  }
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit instance: Printable[A]): Unit = {
      instance.format(value)
    }
  }
}

sealed trait AnotherLight

case object Red extends AnotherLight
case object Yellow extends AnotherLight
case object Green extends AnotherLight

final case class Orders(totalCost: Double, quantity:Double)


object CustomMonoidObjects {
  implicit val orderMonoid: Monoid[Orders] = new Monoid[Orders] {
    override def combine(x: Orders, y: Orders): Orders = Orders(
      x.totalCost |+| y.totalCost , x.quantity |+| y.quantity)

    override def empty: Orders = Orders(0, 0)
  }
}

object MyMain {
  def main(args: Array[String]): Unit = {

    val result = add(List(1,2,3))
    val resultTwo = defineMonad[Id](2: Id[Int])
    println(resultTwo)

  }

  def add(input: List[Int]): Int = {
    input.fold(Monoid[Int].empty)((acc, value) =>
      Monoid[Int].combine(acc, value))
  }

  def someContextMethod[F[_]: Functor](start: F[Int]): F[String] = {
    Functor[F].map(start)(value => (value * 2).toString)
  }

  def defineMonad[Context[_]: Monad](valueWithContext: Context[Int]): Context[Int] = {
    Monad[Context].flatMap(valueWithContext)(eachValue  =>
      valueWithContext.map(value => eachValue  * value)
    )
  }
}
