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
    if(aNumber == 1){
      0
    } else if(aNumber == 2){
      1
    } else {
      fib(aNumber - 1) + fib(aNumber - 2)
    }
  }

  def tailFib(aNumber: Int) = {
    @tailrec
    def go(currentNumber:Int, first:Int, second:Int):Int = {
      if(currentNumber == 1){
        first
      } else if(currentNumber == 2) {
        second
      }else {
        println(s"aNumber is ${currentNumber}, second is ${second}, first is ${first} , ${second + first}")
        go(currentNumber -1, second, first + second)
      }
    }
    go(aNumber,       0, 1)
  }

  def main(args: Array[String]): Unit = {
    println(tailFib(12))
  }
}
