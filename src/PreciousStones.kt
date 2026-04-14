import kotlin.math.max


fun maxProfit(n : Int, values: IntArray): Int {
    val dp = IntArray(n + 1) { -1 }
    return maxProfitUtil(n, values, dp)
}

fun maxProfitUtil(n: Int, values: IntArray, dp: IntArray): Int {
    if (n == 0) return 0
    if(dp[n] != -1) return dp[n]
    for(gem in 1..values.lastIndex + 1) {
        if (n - gem >= 0) {
            dp[n] = max(dp[n], values[gem - 1 ] + maxProfitUtil(n - gem, values,dp))
        }
    }
    return dp[n]
}


fun main() {
    println(
        maxProfit(4, intArrayOf(2,5,7,9))
    )

}