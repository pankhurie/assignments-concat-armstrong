import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
  *Armstrong number
  */
object Armstrong extends App{
  val n = 1000;
  println(Await.result(find(n), 10 second))

  def find(n:Int):Future[List[Int]]=Future{
    def innerFind(n:Int, armSum:Int):Int={
      n match{
        case 0 => armSum
        case _ => innerFind(n/10,armSum+((n%10)*(n%10)*(n%10))) //(2,)
      }
    }
    (for (i <- 1 to n if(i==innerFind(i,0))) yield i).toList
  }

}
