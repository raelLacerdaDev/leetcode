fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    subsetsRecursive(nums = nums, index = 0, subsets = result)
    return result.toList()
}

fun subsetsRecursive(
    nums: IntArray,
    index: Int = 0,
    combination: MutableList<Int> = mutableListOf(),
    subsets: MutableList<List<Int>>,
) {
    if (index > nums.lastIndex ) {
        subsets.add(combination.toList())
        return
    }

    // decisao de escolher
    combination.add(nums[index])
    subsetsRecursive(nums = nums, index =  index + 1, combination =  combination, subsets = subsets)
    // decisao de nao escolher
    combination.remove(nums[index])
    subsetsRecursive(nums = nums, index =  index + 1, combination =  combination, subsets = subsets)
}

fun main() {
    println(
        subsets(nums = intArrayOf(1, 2, 3))
    )
}