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

  def fib(aNumber: Int): Int = {
    if(aNumber == 0){
      0
    } else if(aNumber == 1){
      1
    } else {
      fib(aNumber - 1) + fib(aNumber - 2)
    }
  }

  def main(args: Array[String]): Unit = {
    println(fib(12))
  }
}
