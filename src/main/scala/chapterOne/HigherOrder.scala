package chapterOne

object HigherOrder {

  def someMethod(aRandomNumber:Int): Int = {
    aRandomNumber * 5
  }

  def higherFunction(anInt:Int, f: (Int) =>  Int):Int = {
    f(anInt)
  }

  def curry[A, B, C](f: (A, B) => C): (A) => (B => C) = {
    a => b => f(a, b)
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)
  }

  def main(args: Array[String]): Unit = {
    val returnedValue = higherFunction(4, someMethod)
    println(returnedValue)
  }
}
