/***
Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */


fun reverseString(s: CharArray): Unit {
    reverseStringWithRecursion(s, s.lastIndex, 0)
}

private fun reverseStringWithRecursion(s: CharArray, right: Int, left: Int) {
    if (left >= right) { // break case
        return
    }
    val swap = s[left]
    s[left] =  s[right]
    s[right] = swap
    reverseStringWithRecursion(s, right - 1, left + 1) // recursive call
}


fun main() {
    val charArr = charArrayOf('H', 'e', 'l', 'l', 'o')
    reverseString(charArr)
    println(charArr.contentToString())
}