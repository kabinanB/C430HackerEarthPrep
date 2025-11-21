import DataStructuresClasses.ListNode

object RemoveNthFromEnd {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {

    val dummy = new ListNode(0, head)
    var fast = dummy
    var slow = dummy

    // Move fast n+1 steps so slow lands before the removed node
    for (_ <- 0 to n) {
      fast = fast.next
    }

    // Move fast to end, moving slow with it
    while (fast != null) {
      fast = fast.next
      slow = slow.next
    }

    // Delete the target node
    slow.next = slow.next.next

    dummy.next
  }

  def main(args: Array[String]): Unit = {

    def buildList(nums: List[Int]): ListNode = {
      val dummy = new ListNode()
      var cur = dummy
      for (n <- nums) {
        cur.next = new ListNode(n)
        cur = cur.next
      }
      dummy.next
    }

    def printList(head: ListNode): String = {
      var cur = head
      val buf = scala.collection.mutable.ListBuffer[Int]()
      while (cur != null) {
        buf += cur.x
        cur = cur.next
      }
      buf.toList.toString
    }

    // --- Test Case 1 ---
    val list1 = buildList(List(1, 2, 3, 4, 5))
    val result1 = removeNthFromEnd(list1, 2)
    println("Input: head = [1,2,3,4,5], n = 2")
    println("Output: " + printList(result1))
    println("Expected: [1,2,3,5]\n")

    // --- Test Case 2 ---
    val list2 = buildList(List(1))
    val result2 = removeNthFromEnd(list2, 1)
    println("Input: head = [1], n = 1")
    println("Output: " + printList(result2))
    println("Expected: []\n")

    // --- Test Case 3 ---
    val list3 = buildList(List(1, 2))
    val result3 = removeNthFromEnd(list3, 1)
    println("Input: head = [1,2], n = 1")
    println("Output: " + printList(result3))
    println("Expected: [1]\n")
  }
}
