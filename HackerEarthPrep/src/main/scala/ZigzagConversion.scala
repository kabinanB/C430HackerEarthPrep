object ZigzagConversion {

  def convert(s: String, numRows: Int): String = {
    if (numRows == 1 || s.length <= numRows) return s

    val sb = Array.fill(numRows)(new StringBuilder)
    var i = 0
    val c = s.toCharArray
    val len = c.length

    while (i < len) {
      // vertically down
      for (idx <- 0 until numRows if i < len) {
        sb(idx).append(c(i))
        i += 1
      }
      // obliquely up
      for (idx <- numRows - 2 to 1 by -1 if i < len) {
        sb(idx).append(c(i))
        i += 1
      }
    }

    // merge all rows
    val result = new StringBuilder
    for (row <- sb) result.append(row)
    result.toString()
  }

  def main(args: Array[String]): Unit = {
    println(convert("PAYPALISHIRING", 3)) // Expected: PAHNAPLSIIGYIR
    println(convert("PAYPALISHIRING", 4)) // Expected: PINALSIGYAHRPI
    println(convert("A", 1))              // Expected: A
  }
}
