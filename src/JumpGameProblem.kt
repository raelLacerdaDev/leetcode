


fun canJump(nums: IntArray) : Boolean {
    val dp = IntArray(nums.size) { -1 }
    return canJumpUtil(nums, dp = dp)
}

fun canJumpUtil(nums: IntArray, index: Int = 0, dp: IntArray) : Boolean {

    // dp[index] == 1 -> true
    // dp[index] == 0 -> false
    
    if (index >= nums.size) return false
    if (index == nums.lastIndex) return true

    if (dp[index] != -1) return dp[index] == 1

    val steps = nums[index]
    for(jump in 1..steps) {
        if (index + jump < nums.size) {
           val result = canJumpUtil(nums, index = index + jump, dp = dp)
           if(result) {
               dp[index] = 1
               return true
           }
        }
    }

    dp[index] = 0
    return false
}


fun main() {
    println(
        canJump(intArrayOf(2,3,1,1,4))
    )

    println(
        canJump(intArrayOf(3,2,1,0,4))
    )

}