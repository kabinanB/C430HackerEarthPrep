package DataStructuresClasses

import scala.collection.mutable

object ValidParentheses {

  def isValid(s: String): Boolean = {
    val stk = mutable.Stack[Char]()
    val mp = mutable.HashMap(')' -> '(', '}' -> '{', ']' -> '[')

    for (c <- s) {
      if (mp.contains(c)) { // c is a closing bracket
        if (stk.nonEmpty && stk.top == mp(c))
          stk.pop()
        else
          return false
      } else {
        // c is an opening bracket: push it
        stk.push(c)
      }
    }

    stk.isEmpty
  }

  def main(args: Array[String]): Unit = {
    val tests = List(
      "()" -> true,
      "()[]{}" -> true,
      "(]" -> false,
      "([)]" -> false,
      "{[]}" -> true
    )

    for ((input, expected) <- tests) {
      val result = isValid(input)
      println(s"Input: $input => Output: $result (Expected: $expected)")
    }
  }
}
