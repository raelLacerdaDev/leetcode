class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun reverseList(head: ListNode?): ListNode? {
    return reverse(head, null)
}

private fun reverse(element: ListNode?, previous: ListNode?) : ListNode? {
    if (element == null) return previous
    val node = reverse(element.next, element)
    element.next = previous
    return node
}

fun main() {
    val list = ListNode(1)
    list.next = ListNode(2)
    list.next?.next = ListNode(3)
    list.next?.next?.next = ListNode(4)
    list.next?.next?.next?.next = ListNode(5)

    reverseList(list)

}