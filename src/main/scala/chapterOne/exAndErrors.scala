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

  def secondOptionToAvoidMeanException(xs: Seq[Double], ifEmpty: Double): Double = {
    if(xs.isEmpty) ifEmpty
    else xs.sum / xs.length
  }

  def thirdOptionToAvoidMeanException(xs: Seq[Double]) : Option[Double] = {
    if(xs.isEmpty) None
    else Some(xs.sum / xs.length)
  }

  def someTry[A](aStringNumber: String): Option[Int] = {
    Try(aStringNumber.toInt)
  }

  def Try[A](f: => A): Option[A] = {
    try Some(f)
    catch {case _ : Exception => None}
  }

  def meanWithEither(aSeqOfInt: IndexedSeq[Int]): Either[String, Double] = {
    if(aSeqOfInt.isEmpty){
      Left("Seq can't be empty")
    } else Right(aSeqOfInt.sum/ aSeqOfInt.length)
  }

  def main(args: Array[String]): Unit = {
    mean(Seq())
  }
}
