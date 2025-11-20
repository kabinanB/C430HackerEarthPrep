object MedianOfTwoSortedArray {

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val combined = nums1 ++ nums2
    val combinedSorted = combined.sorted
    val n = combinedSorted.length

    if (n % 2 == 1) {
      // odd length → middle element
      combinedSorted(n / 2)
    } else {
      // even length → average of the two middle elements
      val mid1 = combinedSorted(n / 2 - 1)
      val mid2 = combinedSorted(n / 2)
      (mid1 + mid2) / 2.0
    }
  }

  def main(args: Array[String]): Unit = {

    val nums1 = Array(1, 3)
    val nums2 = Array(2)
    println(s"Input = [${nums1.mkString(", ")}], nums2 = [${nums2.mkString(", ")}]")
    println("Output: " + findMedianSortedArrays(nums1, nums2)) // Expected 2.0

    val nums3 = Array(1, 2)
    val nums4 = Array(3, 4)
    println(s"Input = [${nums3.mkString(", ")}], nums2 = [${nums4.mkString(", ")}]")
    println("Output: " + findMedianSortedArrays(nums3, nums4)) // Expected 2.5
  }
}
