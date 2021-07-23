package chapterOne

import scala.annotation.tailrec

object FunctionalLoops {
  @tailrec
  def justLoop(aNumber: Int):Int ={
    if(aNumber <= 1){
      aNumber
    } else {
      justLoop(aNumber - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    justLoop(11)
  }
}
