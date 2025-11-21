object ContainerWithMostWater {

  def maxArea(height: Array[Int]): Int = {
    var l = 0
    var r = height.size - 1
    var maxlen = 0

    while(l < r) {
      var len = (r-l) * Math.min(height(l), height(r))
      maxlen = Math.max(len, maxlen)
      if(height(l) < height(r)){
        l += 1
      }
      else r -= 1
    }

    maxlen
  }

  def main(args: Array[String]): Unit = {

    val h1 = Array(1,8,6,2,5,4,8,3,7)
    println(s"Input: ${h1.mkString("[", ",", "]")}")
    println("Output: " + maxArea(h1))
    println("Expected: 49\n")

    val h2 = Array(1,1)
    println(s"Input: ${h2.mkString("[", ",", "]")}")
    println("Output: " + maxArea(h2))
    println("Expected: 1\n")

    val h3 = Array(4,3,2,1,4)
    println(s"Input: ${h3.mkString("[", ",", "]")}")
    println("Output: " + maxArea(h3))
    println("Expected: 16\n")

    val h4 = Array(1,2,1)
    println(s"Input: ${h4.mkString("[", ",", "]")}")
    println("Output: " + maxArea(h4))
    println("Expected: 2\n")
  }

}
