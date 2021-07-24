package chapterOne

object HigherOrder {

  def someMethod(aRandomNumber:Int): Int = {
    aRandomNumber * 5
  }

  def higherFunction(anInt:Int, f: (Int) =>  Int):Int = {
    f(anInt)
  }
  def main(args: Array[String]): Unit = {
    val returnedValue = higherFunction(4, someMethod)
    println(returnedValue)
  }
}
