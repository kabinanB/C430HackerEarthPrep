object ThreeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {

    val result = scala.collection.mutable.ListBuffer[List[Int]]()

    if (nums.length < 3) return result.toList

    val sorted = nums.sorted

    for (i <- 0 until sorted.length - 2) {

      // Skip duplicate values for i
      if (i == 0 || sorted(i) != sorted(i - 1)) {

        var left = i + 1
        var right = sorted.length - 1

        while (left < right) {
          val sum = sorted(i) + sorted(left) + sorted(right)

          if (sum == 0) {
            result += List(sorted(i), sorted(left), sorted(right))

            // Skip duplicates for left and right
            while (left < right && sorted(left) == sorted(left + 1)) left += 1
            while (left < right && sorted(right) == sorted(right - 1)) right -= 1

            left += 1
            right -= 1

          } else if (sum < 0) {
            left += 1
          } else {
            right -= 1
          }
        }
      }
    }

    result.toList
  }

  def main(args: Array[String]): Unit = {

    def printResult(result: List[List[Int]]): String = {
      result.map(_.mkString("[", ",", "]")).mkString("[", ",", "]")
    }

    // --- Test Case 1 ---
    val nums1 = Array(-1, 0, 1, 2, -1, -4)
    val result1 = threeSum(nums1)
    println("Input: nums = [-1,0,1,2,-1,-4]")
    println("Output: " + printResult(result1))
    println("Expected: [[-1,-1,2],[-1,0,1]]\n")

    // --- Test Case 2 ---
    val nums2 = Array[Int]()
    val result2 = threeSum(nums2)
    println("Input: nums = []")
    println("Output: " + printResult(result2))
    println("Expected: []\n")

    // --- Test Case 3 ---
    val nums3 = Array(0)
    val result3 = threeSum(nums3)
    println("Input: nums = [0]")
    println("Output: " + printResult(result3))
    println("Expected: []\n")
  }
}
