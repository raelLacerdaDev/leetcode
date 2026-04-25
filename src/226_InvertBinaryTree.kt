import utilities.TreeNode

fun invertTree(root: TreeNode?): TreeNode? {
    invertRecursion(root)
    return root
}


private fun invertRecursion(root: TreeNode?) {
    if (root == null) return

    val swap = root.left
    root.left = root.right
    root.right = swap

    invertRecursion(root.left)
    invertRecursion(root.right)
}

fun main() {
    var ti = TreeNode(3)
    ti.left = TreeNode(9)
    ti.right = TreeNode(20)
    ti.right?.right = TreeNode(7)
    ti.right?.left = TreeNode(15)

    invertRecursion(ti)

    preOrder(ti) {
        println("${it?.`val`}")
    }

}


fun preOrder(root: TreeNode?, onAction:(TreeNode?)-> Unit) {
    if (root == null) return
    onAction(root)
    if (root.left != null) {
        preOrder(root.left, onAction)
    }
    if (root.right != null) {
        preOrder(root.right, onAction)
    }
}


