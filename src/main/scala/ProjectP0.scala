
//IMPORTED LIBRARIES
import scala.io.StdIn
import java.util.Calendar
import java.time.YearMonth
import java.util.ArrayList
import scala.collection.mutable.Set 
import scala.io.Source

object ProjectP0 {
  //GLOBAL VARIABLES
  val moon_data = Source.fromFile("/Users/Mark/Desktop/Project P0/Moon_Data.csv").getLines.toArray
  val moon_ill = Source.fromFile("/Users/Mark/Desktop/Project P0/Illumination_Data.csv").getLines.toArray
  //val phase = Source.fromFile("/Users/Mark/Desktop/moondata.csv").getLines.toArray
  val days =Array(31,28,31,30,31,30,31,31,30,31,30,31)
  var month_entry: Int = 0
  val mon = Array(1,2,3,4,5,6,7,8,9,10,11,12)
  var moon_age : Int =0;
  var phase: String = ""
  val m = Array("January","February","March","April","May","June","July","August","September","October","November","December")
  var day : Int = 0
  //val users : Set[String] = Set("Mark")
  //var events = new ArrayList[Event]
  def main(args: Array[String]): Unit = 
   // args: Array[String]
  {
  
    //take_name()
   intro()
   moons(get_phase(get_day(display_month(get_month()))))
   

    
    //reate_event()
    
  }
  def intro() =
  { 
    print("\033c") 
    //print(lines(50))
    println("-------------------------")
    println("MOON PHASE CALENDAR 2021 ")
    println("-------------------------")
    var full =
      """
         ___---___                    
      .--         --.      
    ./   ()      .-. \.
   /   o    .   (   )  \
  / .            '-'    \         
 | ()    .  O         .  |      
|                         |      
|    o           ()       |
|       .--.          O   |            
 | .   |    |            |
  \    `.__.'    o   .  /    
   \                   /                   
    `\  o    ()      /'          
      `--___   ___--'
            ---
            """
            
            println(full)
    
  }
  def get_month(): Int =
  {
    print("Enter Month (1-12): ")
    println()
    var num = readInt() 
    if(mon.contains(num)){
    println()
    //if(num <) num
    month_entry = num
    return num;
    }
    else 
    {
    println("Retry, Accepted Values Are 1-12.")
    get_month()
    }
  }
  def display_month(num: Int):Int = 
  {
    print("\033c") 
    //val month = Calendar.getInstance.get(Calendar.MONTH)
    
    
    val m1 = m(num -1)
    print("\033c") 
    println("---------------------------")
    println(s"           $m1")
    println("---------------------------")
    var max_days = days(num -1)
    //date.lengthOfMonth() //(Calendar.DAY_OF_MONTH)
    //java.time.YearMonth yearMonthObject = YearMonth.of(1999, 2);
    //int daysInMonth = yearMonthObject.lengthOfMonth(); //28 
    //Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
    //mycal = new GregorianCalendar(2000, Calendar.FEBRUARY, 1);
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
    return max_days
    //get_day()
  }
  def get_day(d:Int): Int =
  {
    print(s"Enter Day: ")
    var num2 = readInt() 
    println()
    if (num2 < 1 | num2 > d)
     { 
      print("\033c") 
      display_month(month_entry)
      println(s"Retry, Accepted Values Are 1-$d.")
      get_day(d)
    }
    else
    {
    //if(num <) num
    //println(num2)
    day = num2
    return num2
    }
  }
  def get_phase(d:Int): Int=
  {
    var i = 0
    if(day > 9)
    {
      i = 1;
    }
    var arr = days.slice(-1,month_entry-1)
    //println("DAY OF YEAR")
    //println(arr)
    var ch = arr.sum-1
    var info_line = moon_data(day+ch)
    var info_line2 = moon_ill(day+ch)
    //println(info_line)
    
    var date = info_line.slice(0,10+i)
    var age1 = info_line.slice(11+i,13+i)
    //println(age1)
    phase = info_line.slice(19+i,21+i)
     //println(phase)
    var illumination = info_line2
    
    //if (illumination.contains(","))
     // {
        //println("it does")
        //illumination = illumination.replace(",","")}
    //var c = info.slice(22,24)//info.charAt(10)
    //println(c)
    
    //println(date)
    
  println(date)
    print("Illumination: ")
    print(illumination)
    println("%")

    print("Moon Age: ")
    print(age1)
    println()
    
  
    
    //println(ch)
    //var p = lines(day+ch)
    //var p2 = p.slice(10,12)
    //per = c2;
   // println(p)
   //var c2 = c.toInt
    moon_age = age1.toInt
    return moon_age
  
  }
  def moons(per:Int) =
  {
    
    var full_moon = 
    """
       _..._     
     .:::::::.    
    :::::::::::   FULL  MOON
    ::::::::::: 
    `:::::::::'  
      `':::''
    """ 
    var wain_gibbous = 
      """
      _..._     
     .::::. `.    
    :::::::.  :    WAINING GIBBOUS
    ::::::::  :  
    `::::::' .'  
      `'::'-' 
      """
      var second_quarter =
        """
      _..._     
     .::::  `.    
    ::::::    :    SECOND QUARTER
    ::::::    :  
    `:::::   .'  
      `'::.-' 
      """
      var wain_crescent =
        """
       _..._     
     .::'   `.    
    :::       :    WAINING CRESCENT
    :::       :  
    `::.     .'  
      `':..-'    
""" 
  var new_moon =
  """
       _..._     
     .'     `.    
    :         :    NEW MOON
    :         :  
    `.       .'  
      `-...-'  
""" 
  var wax_crescent =
    """
        _..._     
     .'   `::.    
    :       :::    WAXING CRESCENT
    :       :::  
    `.     .::'  
      `-..:'' 
""" 
var first_quarter =
  """
        _..._     
     .'  ::::.    
    :    ::::::    FIRST QUARTER
    :    ::::::  
    `.   :::::'  
      `-.::''   
"""
  var wax_gibbous =
    """
        _..._     
     .' .::::.    
    :  ::::::::    WAXING GIBBOUS
    :  ::::::::  
    `. '::::::'  
      `-.::'' 
"""
    //println(moon_age)
   /* if(moon_age == 1 || moon_age == 29){println(new_moon)}
    else if(moon_age > 1 &&  moon_age < 7 ){println(wax_crescent)}
    if(moon_age == 7){println(first_quarter)}
    else if(moon_age > 7 &&  moon_age < 15 ){println(wax_gibbous)}
    if(moon_age == 15){println(full_moon)}
    else if(moon_age > 15 &&  moon_age < 22 ){println(wain_gibbous)}
    if(moon_age == 22){println(second_quarter)}
    else if(moon_age > 22 &&  moon_age < 29 ){println(wain_crescent)}
    else{println("PHASE DATA NOT FOUND.")}*/
    if(phase == "NE"){println(new_moon)
    quit()}
    if(phase == "Q1"){println(first_quarter)
    quit()}
     if(phase == "FU"){println(full_moon)
    quit()}
    if(phase == "Q3"){println(second_quarter)
    quit()}
    else if(moon_age >= 1 &&  moon_age < 8 ){println(wax_crescent)
    quit()}
    
    else if(moon_age > 7 &&  moon_age < 15 ){println(wax_gibbous)
    quit()}
   
    else if(moon_age >= 15 &&  moon_age < 22 ){println(wain_gibbous)
    quit()}
   
    else if(moon_age >= 22 &&  moon_age <= 29 ){println(wain_crescent) 
      quit()}
    else{println("PHASE DATA NOT FOUND.")
  quit()}

  }
   def quit() =
  {
  println()
   println("Press Any Key To Run Again:")
   println("Enter 'q' To Quit: ")
println()
println()
println()
println(".........................................")
println("ASCII Art From: https://www.asciiart.eu/")
println("Lunar Data From: https://in-the-sky.org/")
println(".........................................")
  var q = readLine();
  var a : String = "";
  if (q=="q")
 {System.exit(0)}
   else
  {main(null)}
  }
}