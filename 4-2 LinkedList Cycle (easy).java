// https://www.educative.io/courses/grokking-the-coding-interview/N7rwVyAZl6D
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycle {

  public static boolean hasCycle(ListNode head) {
    ListNode slowNode = head;
    ListNode fastNode = head;

    do {
      // Iterate fast ptr
      for (int i = 0; i < 2; i++) {
        fastNode = fastNode.next;
        if (fastNode == null) {
          return false;
        }
      }

      // Iterate slow ptr
      slowNode = slowNode.next;
    } while (slowNode.value != fastNode.value);
    return true;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
  }
}
