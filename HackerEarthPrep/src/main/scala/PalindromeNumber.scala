object PalindromeNumber {

  def isPalindrome(x: Int): Boolean = {
    val s = String.valueOf(x)
    var l = 0
    var r = s.size - 1

    while(l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false
      }
      l += 1
      r -= 1
    }
    true
  }

  def main(args: Array[String]): Unit = {

    //Test Case 1

    val x = 121
    println(s"Input x = $x")
    println("output: " + isPalindrome(x) )

    //Test Case 2

    val y = -121
    println(s"Input y = $y")
    println("output: " + isPalindrome(y))

    //Test Case 3

    val z = 10
    println(s"Input z = $z")
    println("output: " + isPalindrome(z))

    //Test Case 4

    val a = -101
    println(s"Input a = $a")
    println("output: " + isPalindrome(a))
  }

}
