import utilities.TreeNode
import kotlin.math.max

/***
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

 */



fun maxDepth(root: TreeNode?): Int {
    return preOrderRecursive(root)
}

private fun preOrderRecursive(root: TreeNode?) : Int {
    if (root == null) return 0
    val depthLeft = preOrderRecursive(root.left)
    val depthRight = preOrderRecursive(root.right)
    return 1 + max(depthLeft, depthRight)
}


fun main() {
    var ti = TreeNode(3)
    ti.left = TreeNode(9)
    ti.right = TreeNode(20)
    ti.right?.right = TreeNode(7)
    ti.right?.left = TreeNode(15)
    println(
        maxDepth(ti) // 3
    )

}