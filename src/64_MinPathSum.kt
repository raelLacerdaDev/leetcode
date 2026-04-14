import kotlin.math.min


fun minPathSum(grid: Array<IntArray>): Int {
    val dp = Array(grid.size) { IntArray(grid[0].size) {-1} }
    return minPathSumUtil(grid,dp = dp)
}

fun minPathSumUtil(grid: Array<IntArray>, i : Int = 0, j: Int = 0, dp: Array<IntArray>): Int {

    if (i >= grid.size || j >= grid[0].size) return Int.MAX_VALUE

    if (i == grid.lastIndex && j == grid[0].lastIndex) return grid[i][j]

    if (dp[i][j] != -1) { return dp[i][j] }

    var minBellow = Int.MAX_VALUE
    var minRight = Int.MAX_VALUE

    if (i + 1 <= grid.lastIndex ) {
        val bellow  = grid[i][j] + minPathSumUtil(grid, i + 1, j, dp)
        minBellow = min(minBellow,bellow)
    }

    if (j + 1 <= grid[0].lastIndex) {
        val right = grid[i][j] + minPathSumUtil(grid, i, j + 1, dp)
        minRight = min(minRight,right)
    }

   dp[i][j] = min(minBellow,minRight)
    return dp[i][j]
}



fun main() {

    val grid = Array(3) {
        IntArray(3) {
            0
        }
    }
    grid[0][0] = 1
    grid[0][1] = 3
    grid[0][2] = 1
    grid[1][0] = 1
    grid[1][1] = 5
    grid[1][2] = 1
    grid[2][0] = 4
    grid[2][1] = 2
    grid[2][2] = 1

    println(
        minPathSum(grid)
    )
}