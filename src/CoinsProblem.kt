import kotlin.math.min


fun main (){
    println(
        coinsProblem(
            intArrayOf(5,2,1),
            amount = 11
        )
    )

}

fun coinsProblem(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { -1 }
    val result = coinsProblemUtil(coins, amount, dp)

    return if (result == Int.MAX_VALUE) -1 else result
}

fun coinsProblemUtil(coins: IntArray, amount: Int, dp: IntArray): Int {

    if (amount == 0) return 0
    if (dp[amount] != -1) return dp[amount]


    var minCoins = Int.MAX_VALUE

    for (coin in coins) {
        if (amount - coin >= 0) {
            val res = coinsProblemUtil(coins, amount - coin, dp)

            if (res != Int.MAX_VALUE) {
                minCoins = minOf(minCoins, 1 + res)
            }
        }
    }

    dp[amount] = minCoins
    return dp[amount]
}