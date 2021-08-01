package chapterOne

object LazyEval {

  def if2[A](someCondition: Boolean, ifTrue: => A, ifFalse: => A): A = {
    if(someCondition) ifTrue else ifFalse
  }

  def if3(condition: Boolean, firstValue: => Int, secondValue: => Int):Int ={
    if (condition){
      firstValue + firstValue
    } else  {
      secondValue + secondValue
    }
  }

  def maybeTwice(b: Boolean, i: => Int) = if (b) i + i else 0

  def main(args: Array[String]): Unit = {

    /*** Interesting finding => How is 3 of type : => Int?? **/
    type OwnType = () => Int
    val trueValue: OwnType  = () => 4
    val falseValue: OwnType = () => 10

    if2(true, trueValue, falseValue)()
    if2(false, sys.error("fail"), 3)
    if3(true, {println("Hello"); 4}, {println("now"); 9} )
    maybeTwice(true, {println("hi"); 1+41})
  }
}
