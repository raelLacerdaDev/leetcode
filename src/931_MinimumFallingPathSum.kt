import kotlin.math.min

fun minFallingPathSum(matrix: Array<IntArray>): Int {

    val dp = Array(matrix.size) {
        IntArray(matrix.size) { -1 }
    }

    for (j in dp[0].indices) {
        dp[0][j] = matrix[0][j] // casos bases
    }

    // fill
    for (i in 1.. dp.lastIndex) {
        for (j in dp[i].indices) {
            val above = dp[i - 1][j]
            val topLeft =  if (j > 0) dp[i - 1][j - 1] else Int.MAX_VALUE
            val topRight = if(j < matrix.size - 1) dp[i - 1][j + 1] else Int.MAX_VALUE
            dp[i][j] = matrix[i][j] + minOf(above, topLeft, topRight)
        }
    }

    var min = Int.MAX_VALUE
    val lastLine = dp.lastIndex
    for (j in dp[lastLine].indices) {
        min = min(min, dp[lastLine][j])
    }

    return min
}


fun main() {

}