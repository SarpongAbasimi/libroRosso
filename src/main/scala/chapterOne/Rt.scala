package chapterOne

object Rt {
  // referential transparency

  def rp: String = {
    val x = "Hello World"
    x.reverse // dlroW olleH
    x.reverse

    //now
    "Hello World".reverse  // dlroW olleHs
  }

  def notSoRt = {
    // string builder.append is not a pure function
    val x =  new StringBuilder("hello")
    val y = x.append(", world") // Hello, world
    val y2 = y.append("world")  // Hello, world world

  }
  def main(args: Array[String]): Unit = {

  }
}
