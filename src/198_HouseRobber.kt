import kotlin.math.max


fun rob(nums: IntArray): Int {
    val dp = IntArray(nums.size) { -1 }
    return robUtil(nums, dp = dp)
}


fun robUtil (nums: IntArray, index: Int = 0, dp: IntArray): Int {

    if (index < 0 || index >= nums.size) return 0

    if (dp[index] != -1 ) return dp[index]


    val rob = nums[index] + robUtil(nums, index + 2, dp)
    val noRob = robUtil(nums, index + 1, dp = dp)

    dp[index] = max(rob, noRob)
    return dp[index]
}




fun main() {

    println(
        rob(intArrayOf(1,2,3,1))
    )

    println(
        rob(intArrayOf(2,7,9,3,1))
    )

}






