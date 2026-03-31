import kotlin.math.min


fun coinChange(coins: IntArray, amount: Int): Int {
    var min = 0
    min = coinChangeRecursive(coins = coins, amount =  amount)
    return min
}

// O(n ^ V) exponential
private fun coinChangeRecursive(
    coins: IntArray,
    amount: Int,
    quantity : Int = 0,
    min: IntArray = IntArray(1) { Int.MAX_VALUE }
): Int {

    if (amount == 0) {
        return quantity
    }

    for (i in coins.indices) {
        if (amount - coins[i] >= 0) {
            val newValue = amount - coins[i]
            val current = coinChangeRecursive(coins = coins, amount = newValue, quantity = quantity + 1, min = min)
            min[0] = min(min[0], current)
        }
    }

    if (min[0] == Int.MAX_VALUE) {
        return -1
    }

   return min[0]
}

fun coinChangeMemoized(
    coins: IntArray,
    amount: Int,
    memo: MutableMap<Int, Int> = mutableMapOf()
): Int {

    if (amount == 0) return 0
    if (amount < 0) return -1

    if (memo.containsKey(amount)) {
        return memo[amount]!!
    }

    var minCoins = Int.MAX_VALUE


    for (coin in coins) {
        val result = coinChangeMemoized(coins, amount - coin, memo)


        if (result in 0..<minCoins) {
            minCoins = result + 1
        }
    }

    memo[amount] = if (minCoins == Int.MAX_VALUE) -1 else minCoins
    return memo[amount]!!
}




fun main() {
    val coins = intArrayOf(10,7,1)
//    println(
//        coinChange(coins = coins, amount = 100)
//    )

    println(
        coinChangeMemoized(coins = coins, amount = 100)
    )
}