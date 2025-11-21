object ReverseInteger{

  def reverse(x: Int): Int = {

    // Convert to string
    val str = x.toString
    var rev = ""

    // Reverse without the sign
    if (x < 0)
      rev = "-" + str.substring(1).reverse
    else
      rev = str.reverse

    // Convert to Long first to detect overflow
    val result = rev.toLong

    if (result > Int.MaxValue || result < Int.MinValue)
      0
    else
      result.toInt
  }

  def main(args: Array[String]): Unit = {
    val tests = List(
      123 -> 321,
      -123 -> -321,
      120 -> 21,
      0 -> 0
    )

    for ((input, expected) <- tests) {
      val output = reverse(input)
      println(s"Input: $input => Output: $output (Expected: $expected)")
    }
  }
}
