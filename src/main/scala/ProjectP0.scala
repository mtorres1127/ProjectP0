
import scala.io.StdIn
import java.util.Calendar
import java.time.YearMonth
import java.util.ArrayList
import scala.collection.mutable.Set 
import scala.io.Source

object ProjectP0 {
  val lines = Source.fromFile("/Users/Mark/Desktop/moon.txt").getLines.toArray
  val phase = Source.fromFile("/Users/Mark/Desktop/moondata.csv").getLines.toArray
  val days =Array(31,28,31,30,31,30,31,31,30,31,30,31)
  var month_entry: Int = 0
  val mon = Array(1,2,3,4,5,6,7,8,9,10,11,12)
  var per : Int =0;
  val m = Array("January","February","March","April","May","June","July","August","September","October","November","December")
  //val users : Set[String] = Set("Mark")
  //var events = new ArrayList[Event]
  def main(args: Array[String]): Unit = 
   // args: Array[String]
  {
  
    //take_name()
   intro()
   moons(get_phase(get_day(display_month(get_month()))),per)
   quit()

    
    //reate_event()
    
  }
  def intro() =
  { 
    print("\033c") 
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
    var num = readInt() 
    if(mon.contains(num)){
    println()
    //if(num <) num
    month_entry = num
      return num;
    }
    else {println("Retry, Accepted Values Are 1-12.")
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
    print(s"     Enter Day:")
    val num2 = readInt() 
    println()
    if (num2 < 1 | num2 > d)
     { print("\033c") 
     display_month(month_entry)
       println(s"Retry, Accepted Values Are 1-$d.")
      get_day(d)}
       else{
    //if(num <) num
    //println(num2)
    return num2}
  }
  def get_phase(day:Int): String=
  {
    var info = lines(50+day)
    var c = info.slice(22,24)//info.charAt(10)
    //println(c)
    var c2 = c.toInt
    print("Percent of Moon Visible: ")
    print(c2)
    println("%")
    var arr = days.slice(-1,month_entry-1)
    var ch = arr.sum-1
    //println(ch)
    var p = phase(day+ch)
    var p2 = p.slice(10,12)
    per = c2;
    println(p)
    return p2
  
  }
  def moons(t :String,per:Int) =
  {
    
    var new_moon = 
    """
       _..._     
     .:::::::.    
    :::::::::::   NEW  MOON
    ::::::::::: 
    `:::::::::'  
      `':::''
    """ 
    var waxing_cresent = 
      """
      _..._     
     .::::. `.    
    :::::::.  :    WAXING CRESCENT
    ::::::::  :  
    `::::::' .'  
      `'::'-' 
      """
      var first_quarter =
        """
      _..._     
     .::::  `.    
    ::::::    :    FIRST QUARTER
    ::::::    :  
    `:::::   .'  
      `'::.-' 
      """
      var wax_gibbous =
        """
       _..._     
     .::'   `.    
    :::       :    WAXING GIBBOUS
    :::       :  
    `::.     .'  
      `':..-'    
""" 
  var full =
  """
       _..._     
     .'     `.    
    :         :    FULL MOON
    :         :  
    `.       .'  
      `-...-'  
""" 
  var wain_gibbous =
    """
        _..._     
     .'   `::.    
    :       :::    WANING GIBBOUS
    :       :::  
    `.     .::'  
      `-..:'' 
""" 
var last_quarter =
  """
        _..._     
     .'  ::::.    
    :    ::::::    LAST QUARTER
    :    ::::::  
    `.   :::::'  
      `-.::''   
"""
  var wain_crecent =
    """
        _..._     
     .' .::::.    
    :  ::::::::    WANING CRESCENT
    :  ::::::::  
    `. '::::::'  
      `-.::'' 
"""
var newm = 
  """
       _..._     
     .:::::::.    
    :::::::::::    NEW MOON
    :::::::::::  
    `:::::::::'  
      `':::''
      """
    if(t == "WN" &&  per > 50 ){println(wain_gibbous)}
    else if(t == "WN" &&  per < 50 ){println(wain_crecent)}
    else if (t=="WX"){println(wax_gibbous)}
    else if(t=="N"){println(newm)}
    else if(t =="F"){println(full)}
    else if(t == "Q1"){println(first_quarter)}
    else if(t=="Q3"){println(last_quarter)}
    else{println("PHASE DATA NOT FOUND.")}

  }
   def quit() =
  {
   println("To Run Again Enter 1:")
  var q = readInt();
  var a : String = "";
  if (q==1){main(null)}
  else {System.exit(0)}
  }
}