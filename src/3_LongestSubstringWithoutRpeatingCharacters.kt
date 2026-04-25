import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles
import kotlin.math.max


fun lengthOfLongestSubstring(s: String): Int {

   val map = mutableMapOf<Char, Int>()
   var maxLength = 0
   var distance = 0


   var left = 0
   var current = 0

   for (char in s) {
      if (map.containsKey(char)) {
         val index = map.getValue(char)
         left = max(left, index + 1)
      }
      distance = (current - left) + 1
      maxLength = max(maxLength, distance)
      map[char] = current
      current += 1
   }


   return maxLength
}




fun main() {
   println(
      lengthOfLongestSubstring("abcabcbb")
   )
}