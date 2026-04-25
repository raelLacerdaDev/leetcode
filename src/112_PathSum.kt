import utilities.TreeNode

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    return pathSum(root, targetSum)
}

private fun pathSum(root: TreeNode?, targetSum: Int, pathSum : Int =  0): Boolean {
    if (root == null) return false
    val sum = pathSum + root.`val`
    if (sum == targetSum && root.left == null && root.right == null) return true

    if(pathSum(root.left, targetSum,sum)) return true
    if(pathSum(root.right, targetSum,sum)) return true

    return false
}


fun main() {
    var ti = TreeNode(3)
    ti.left = TreeNode(9)
    ti.right = TreeNode(20)
    ti.right?.right = TreeNode(7)
    ti.right?.left = TreeNode(15)

    println(
        hasPathSum(ti, targetSum = 38)
    )

}