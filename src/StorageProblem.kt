import kotlin.math.max

fun main() {
    println(
        maxWarehouseValue(
            c = 10,
            n = 4,
            prices = intArrayOf(5,12,8,1),
            volume = intArrayOf(4,8,5,3)
        )
    )


    println(
        maxWarehouseValue(
            c = 10,
            n = 4,
            prices = intArrayOf(5,15,8,1),
            volume = intArrayOf(4,8,5,3)
        )
    )

    println(
        maxWarehouseValue(
            c = 3,
            n = 3,
            prices = intArrayOf(1,2,3),
            volume = intArrayOf(4,5,1)
        )
    )


    println(
        maxWarehouseValue(
            c = 3,
            n = 3,
            prices = intArrayOf(1,2,3),
            volume = intArrayOf(4,5,6)
        )
    )

    println(
        maxWarehouseValue(
            c = 0,
            n = 3,
            prices = intArrayOf(20,30,40),
            volume = intArrayOf(10,20,30)
        )
    )

    println(
        maxWarehouseValue(
            c = 100,
            n = 0,
            prices = intArrayOf(),
            volume = intArrayOf()
        )
    )


}



fun maxWarehouseValue(c: Int, n: Int, prices: IntArray, volume: IntArray) : Int {
    val dp = Array(n) { IntArray(c + 1) { -1 } }
    return maxWarehouseValueUtil(c,n,prices,volume,dp)
}

fun maxWarehouseValueUtil(
    c: Int,
    n: Int,
    prices: IntArray,
    volume: IntArray,
    dp: Array<IntArray>,
    index: Int = 0
): Int {
    if (index >= n) return 0;
    if (dp[index][c] != -1) return dp[index][c]

    val choose = if(volume[index] <= c) prices[index] + maxWarehouseValueUtil(c - volume[index],n,prices,volume,dp, index + 1) else 0
    val dontChoose = maxWarehouseValueUtil(c,n,prices,volume,dp, index + 1)

    dp[index][c] = max(choose,dontChoose)
    return dp[index][c]
}

