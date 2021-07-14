import java.io.StringReader
import scala.io.StdIn.readLine
object Hello_World {
  def main(args: Array[String]): Unit = {

// Question 1
  val donut = "Vanilla Donut"
  val numDonut = 10
  
  val price = 2.50
  val donutBasic =
    s"""
       |{
       |"donut_name":"$donut",
       |"quantity_purchased":"$numDonut",
       |"price":$price
       |}
      """
  println(donutBasic)

// Question 2
import scala.io.StdIn._
    val name = readLine("Input Name: ")
    println("Input Age: ")
    val age = readInt()
    print("Name: ")
    print(name)
    print("Age: ")
    print(Console.RESET)
    print(age)

// Question 3
  val s = "http://allaboutscala.com"
  println("8th character:")
  println(s(7))

// Question 4
val total : Double = numDonut*price
print("$")
println(f"$total%1.2f")

// Question 5
import scala.io.StdIn._
val movie = readLine("What is your favorite movie of all times?")

// Question 6
val name = readLine("Input Name: ")
val bas = 
s"""
 |{
 | "Name":"$name",
 | "Favorite Movie":"$movie",
 |}
  """
 println(bas)

 // Question 7
val don = "Vanilla Donut 10 2.25"
 val split = don.split(" ")
 val donutOutput =
  s"""
 |Donut Name: Vanilla Donut
 |Donut Price: 2.25
 |Donut Purchased: 10
 """.stripMargin
 println(donutOutput)

 // Questsion 8
 val info = Map("Bill"->9,"Jonny"->8,"Cindy"->"13","Tommy"->11)

 // Question 9 
val basket1 = Array("Cake","Milk","Cheese","Toilet Paper")
val basket2 = Array("Bread", "Water", "Juice", "Milk","Cheese")
val com = basket1 intersect basket2
 print("Output:")
 println()
 print("Basket1:")
 basket1.foreach(n => print(s"$n "))
 print("Basket2:")
 basket2.foreach(n => print(s"$n "))
 println("Common items are: ")
 com.foreach(n => print(s"$n "))

 // Question 10
 val x = Vector.range(100,111)
 print("Output:")
 println()
 print("Number range from 100 to 110 incluisve =  ")
 x.foreach(n => print(s"$n "))

 }}

  // Question 2
    //println("Name:")
   // val name = readLine("Name:")
   // print("Age:")
   // val age = readInt()

// Question 1
//def q1(a:Int,b:Int):Int=if(a == b) (a+b)*3 else (a+b)
// Question 2
//def q2(a:String):String=a(a.length-1) +a + a(a.length-1)
//println(q2("dog"))
// Question 5
//def q5(a: Int):Boolean = if ((79 < a && a < 121) || (279 < a && a < 321)) true else false
//}

// Question 1

// Question 2










// Pure Function
def sq(a:Int): Int = 
{return a*a}

// Impure Function
var count = 5
def inc()
{count = count +1
println(count)}
