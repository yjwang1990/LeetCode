package two_add_2;


class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode listNode = new ListNode(0);
    ListNode p = listNode;

    while (carry != 0 || l1 != null || l2 != null) {
      int a = 0;
      int b = 0;
      if (l1 != null) {
        a = l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        b = l2.val;
        l2 = l2.next;
      }
      int currentDigit = a + b + carry;
      p.next = new ListNode(currentDigit % 10);
      carry = currentDigit / 10;
      p = p.next;
    }
    return listNode;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}