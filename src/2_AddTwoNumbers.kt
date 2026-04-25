
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    return addTwoNumbersUtil(l1,l2)
}


fun addTwoNumbersUtil (l1: ListNode?, l2: ListNode?, transport : Int = 0) : ListNode? {
    if (l1 == null && l2 == null && transport == 0) return null

    val valueL1 = l1?.`val` ?: 0
    val valueL2 = l2?.`val` ?: 0
    val sum = valueL1 + valueL2 + transport

    val result = ListNode(sum % 10)
    result.next = addTwoNumbersUtil(l1?.next, l2?.next, transport = sum / 10)

    return result
}




fun main() {
    val list1 = ListNode(2)
    list1.next = ListNode(4)
    list1.next?.next = ListNode(3)

    val list2 = ListNode(5)
    list2.next = ListNode(6)
    list2.next?.next = ListNode(4)

    addTwoNumbersUtil(list1, list2)

}