import kotlin.math.min


fun minCostClimbingStairs(cost: IntArray): Int {
    val dp = IntArray(cost.size) { -1 }
    return min(minCostClimbingStairsUtil(cost, dp = dp), minCostClimbingStairsUtil(cost, index = 1, dp = dp))
}

fun minCostClimbingStairsUtil(
    cost: IntArray,
    index: Int = 0,
    dp: IntArray,
) : Int {
    if (index >= cost.size) return 0
    if (dp[index] != -1) {
        return dp[index]
    }
    dp[index] = cost[index] + min(
        minCostClimbingStairsUtil(cost, index + 1,dp),
        minCostClimbingStairsUtil(cost, index + 2,dp)
    )
    return dp[index]
}


fun main() {
    println(
        minCostClimbingStairs(intArrayOf(10,15,20))
    )
}