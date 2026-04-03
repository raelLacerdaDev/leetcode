

fun climbStairs(n: Int) : Int {
    return climbStairsUtil(n)
}

private fun climbStairsUtil(
    n: Int,
    dp : IntArray = IntArray(n + 1) { -1 }
) : Int {

    if (n < 0) return 0
    if (n == 0) return 1
    if (dp[n] != -1) return dp[n]

    dp[n] = climbStairsUtil(n - 1,  dp) + climbStairsUtil(n - 2,  dp)

    return dp[n]
}

fun main() {

    println(
        climbStairs(2)
    )

    println(
        climbStairs(3)
    )

    println(
        climbStairs(5)
    )

    println(
        climbStairs(45)
    )

}