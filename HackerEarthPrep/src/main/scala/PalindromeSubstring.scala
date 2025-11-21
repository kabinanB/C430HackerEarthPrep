object PalindromeSubstring {

  def longestPalindrome(s: String): String = {

    // Base case: if string is empty or palindrome itself
    if (s.length <= 1 || s == s.reverse) {
      return s
    }

    // Recursively check substring without first char and without last char
    val left = longestPalindrome(s.substring(1))
    val right = longestPalindrome(s.substring(0, s.length - 1))

    // Return the longer palindrome
    if (left.length > right.length) left else right
  }

  def main(args: Array[String]): Unit = {

    val s1 = "babad"
    println(s"Input: $s1")
    println("Output: " + longestPalindrome(s1))
    println("Note: 'bab' or 'aba' are valid")

    val s2 = "cbbd"
    println(s"\nInput: $s2")
    println("Output: " + longestPalindrome(s2))

    val s3 = "a"
    println(s"\nInput: $s3")
    println("Output: " + longestPalindrome(s3))

    val s4 = "ac"
    println(s"\nInput: $s4")
    println("Output: " + longestPalindrome(s4))
  }
}
