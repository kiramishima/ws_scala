object Lab {
  // Ex 1
  def cleanFunc(s:String):String = {
      if(s.contains("()"))
      {
          val s2 = s.replace("()","")
          cleanFunc(s2)
      } else {
            s
      }
  }

  def getMin(s: String): Int = {
      val sDef = cleanFunc(s)
      if( sDef.length() == 0 ){
          return 0
      }
      if( sDef.charAt(0) == "("){
          sDef.length()
      }else{
          val (l1,l2) = sDef.split("").partition( x=> x == "(")
          l1.size + l2.size
      }

      //val (l1,l2) = s.split("").partition( x=> x == "(")
      //Math.abs(l1.size - l2.size)
  }

  // Ex 2 
  def minX(arr: Array[Int]): Int = {
    var acc = 0 
    val parejas = for (i <- 0 to arr.size-1) yield {
      acc = acc + arr(i) 
      acc
    }
    
    //(parejas).foreach(println)
    val np = (parejas).min
    
    return Math.abs(np)+1
    //return -1000
  }

  // Ex 3
  def countNonUnique(numbers: Array[Int]): Int = {
    numbers.groupBy( x => x).map( x => x._2).filter(x => x.size>1).size
  }

  // Ex 4
  def minDiff(arr: Array[Int]): Int = {
    var flag = true
    val t = arr.sorted
    val parejas = for (i <- 0 to t.size-2) yield {
      (t(i),t(i+1))
    }
    return parejas.map(x=> Math.abs(x._1-x._2) ).reduce( (a,b)=> a+b )  
  }
}

object Main extends App {
  println("** Test ** ")
  println(Lab.getMin(")(")) // 2
  println(Lab.getMin("()()")) // 0

  println(Lab.minX(Array(-2, 3, 1, -5))) // 4
  
  println(Lab.countNonUnique(Array(1,2,3))) // 0
  println(Lab.countNonUnique(Array(1,2,1,3))) // 1
  println(Lab.countNonUnique(Array(1,2,1,3,4,5,2,3))) // 3

}