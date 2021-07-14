
import scala.io.StdIn
import java.util.Calendar


object ProjectP0 {


def main(args: Array[String]): Unit = 
{
import scala.collection.mutable.Set 

val users : Set[String] = Set("Mark")
take_name()
display_month()


def take_name(): String =
{
      val line1 =
      """
      ----------------------------------
                 Welcome! 
       Enter Name for Calendar Access: 
      ----------------------------------
      """
      
      println(line1)
      

     val name = scala.io.StdIn.readLine()
     
      if (users.contains(name))
      {
        println("Name Found!")
      }
      else
      {
        println("New Name")
      }
      return name
}


def display_month() =
  {
  val month = Calendar.getInstance.get(Calendar.MONTH)
  val m = Array("January","February","March","April","May","June","July","August","September","October","November","December")

  val m1 = m(month)
  println("---------------------------")
  println(s"           $m1")
  println("---------------------------")
  var max_days = 30//date.lengthOfMonth() //(Calendar.DAY_OF_MONTH)
 for(x <- 1 to max_days) 
 {
   if (x <=9 && x != 8){print(x + "   ")}
   else if(x==8){println()
   print(x + "   ")}
   else if( x== 15||x == 22||x == 29){println() 
    print(x + "  ")}
   else if (x>=10){print(x + "  ")}
 }
 println()
 println("---------------------------")
 println()
}

}



}