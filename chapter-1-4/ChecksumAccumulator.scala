class ChecksumAccumulator{
  private  var sum = 0

  def add(b: Byte) = {
    //b = 1 // this won't compile
    sum += b
  }

  def checksum() = ~(sum & 0xFF) + 1
  /* def checksum(): Int = {
    return ~(sum & 0xFF) + 1
  }*/
}

//val acc = new ChecksumAccumulator
//val csa = new ChecksumAccumulator

//acc = new ChecksumAccumulator

//acc.sum = 3

/******************
Companion Object
*******************/

import scala.collection.mutable

object ChecksumAccumulator{
  
  private val cache = mutable.Map.empty[String, Int]
  
  def calculate(s: String): Int = 
    if(cache.contains(s))
      cache(s)
    else{
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }

}
