// https://www.educative.io/courses/grokking-the-coding-interview/N7pvEn86YrN
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycleStart {

  public static ListNode findCycleStart(ListNode head) {
    ListNode slowNode = head;
    ListNode fastNode = head.next;

    // Getting the length of the cycle
    int cycleLength = 0;
    int cycleCompletions = 0;
    do {
      if (fastNode.value == slowNode.value) {
        cycleCompletions++;
      }

      if (cycleCompletions == 1) {
        cycleLength++;
      }

      slowNode = slowNode.next;
      fastNode = fastNode.next.next;

    } while(cycleCompletions != 2);

    
    // Moving the fast pointer ahead by cycleLength
    slowNode = head;
    fastNode = head;
    for (int i = 0; i < cycleLength; i++) {
      fastNode = fastNode.next;
    }

    // Getting the start of the cycle
    while (slowNode.value != fastNode.value) {
      slowNode = slowNode.next;
      fastNode = fastNode.next;
    }

    return slowNode;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
  }
}
