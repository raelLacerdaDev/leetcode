import kotlin.math.abs
import kotlin.math.min

fun main() {
    println(
        minJumpsValue(intArrayOf(10,30,40,20))
    )

}


fun minJumpsValue(values: IntArray) : Int {
    val dp = IntArray(values.size) { -1 }
    return minJumpsUtil(values, dp = dp)
}


fun minJumpsUtil(values: IntArray, index: Int = 0, dp: IntArray) : Int {
    if (index >= values.lastIndex) {
        return 0
    }

    if (dp[index] != -1) {
        return dp[index]
    }

    val costJumpOne = abs(values[index] - values[index + 1]) + minJumpsUtil(values, index + 1, dp = dp)
    var costJumpTwo = Int.MAX_VALUE
    if (index + 2 <= values.lastIndex) {
        costJumpTwo = abs(values[index] - values[index + 2]) + minJumpsUtil(values, index + 2, dp = dp)
    }
    dp[index] = min(costJumpOne, costJumpTwo)
    return dp[index]
}