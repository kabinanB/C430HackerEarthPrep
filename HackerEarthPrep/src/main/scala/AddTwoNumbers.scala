import DataStructuresClasses.ListNode

object AddTwoNumbers {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    var p1 = l1
    var p2 = l2
    var carry = 0

    val dummy = new ListNode()
    var cur = dummy

    while (p1 != null || p2 != null || carry != 0) {

      val v1 = if (p1 != null) p1.x else 0
      val v2 = if (p2 != null) p2.x else 0

      val total = v1 + v2 + carry
      carry = total / 10

      cur.next = new ListNode(total % 10)
      cur = cur.next

      if (p1 != null) p1 = p1.next
      if (p2 != null) p2 = p2.next
    }

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

    def printList(head: ListNode): Unit = {
      var cur = head
      val buf = scala.collection.mutable.ListBuffer[Int]()
      while (cur != null) {
        buf += cur.x
        cur = cur.next
      }
      println(buf.toList)
    }

    //Test case 1
    val l1 = buildList(List(2, 4, 3))
    val l2 = buildList(List(5, 6, 4))
    printList(addTwoNumbers(l1, l2))  // expected [7,0,8]


    //Test case 2
    val l3 = buildList(List(0))
    val l4 = buildList(List(0))
    printList(addTwoNumbers(l3, l4))  // expected [0]


    //Test case 3
    val l5 = buildList(List(9, 9, 9, 9, 9, 9, 9))
    val l6 = buildList(List(9, 9, 9, 9))
    printList(addTwoNumbers(l5, l6))  // expected [8,9,9,9,0,0,0,1]
  }
}
