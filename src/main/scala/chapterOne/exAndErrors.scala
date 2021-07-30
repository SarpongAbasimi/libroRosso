package chapterOne

object exAndErrors {

  def failing(aNumber:Int):Int = {
    //This will run immediately
//    val y:Int = throw new Exception("Fail")
    try {
      val x = 42 + 5
      x +  (
        (throw new Exception("Fail")) :Int
      )
    } catch {
      case  exception: Exception => {
        println(43)
        43
      }
    }
  }

  def mean(xs: Seq[Double]): Double = {
    if(xs.isEmpty){
      throw new ArithmeticException("Mean of empty list")
    } else {
      xs.sum / xs.length
    }
  }

  def optionOneToAvoidMeanException(xs: Seq[Double]): Double = {
    if(xs.isEmpty) Double.NaN
    else xs.sum / xs.length
  }

  def main(args: Array[String]): Unit = {
    mean(Seq())
  }
}
