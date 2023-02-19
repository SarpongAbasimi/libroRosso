package tpclasses
import scala.language.implicitConversions

trait Printable[A]{
  def format(value: A)
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

import PrintableSyntax._
import PrintableInstances._

object MyMain {
  def main(args: Array[String]): Unit = {

    Cat("Mao", 1, "red").format
  }
}
