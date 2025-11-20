object LongestSubstring {

  def lengthOfLongestSubstring(s: String): Int = {
    var left = 0
    var maxlen = 0

    var charSet: Set[Char] = Set()

    for (right <- 0 until s.length) {
      while (charSet.contains(s(right))) {
        charSet -= s(left)
        left += 1
      }
      charSet += s(right)
      maxlen = Math.max(maxlen, right - left + 1)
    }

    maxlen
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("abcabcbb"))  // 3
    println(lengthOfLongestSubstring("bbbbb"))     // 1
    println(lengthOfLongestSubstring("pwwkew"))    // 3
    println(lengthOfLongestSubstring(""))          // 0
  }
}
