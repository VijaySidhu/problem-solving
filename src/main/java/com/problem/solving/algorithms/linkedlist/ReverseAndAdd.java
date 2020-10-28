package com.problem.solving.algorithms.linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 * <p>
 * Complexity Analysis
 * <p>
 * Time complexity : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1
 * and l2l2 respectively, the algorithm above iterates at most \max(m, n)max(m,n) times.
 * <p>
 * Space complexity : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) +
 * 1max(m,n)+1.
 */
public class ReverseAndAdd {

  public static void main(String[] args) {
    Node l1 = new Node(2, new Node(4, new Node(3, null)));
    Node l2 = new Node(5, new Node(6, new Node(4, null)));
    Node result = addTwoNumbers(l1, l2);
    System.out.println(result);
  }

  /**
   * Initialize current node to dummy head of the returning list. Initialize carry to 00. Initialize
   * pp and qq to head of l1l1 and l2l2 respectively. Loop through lists l1l1 and l2l2 until you
   * reach both ends. Set xx to node pp's value. If pp has reached the end of l1l1, set to 00. Set
   * yy to node qq's value. If qq has reached the end of l2l2, set to 00. Set sum = x + y +
   * carrysum=x+y+carry. Update carry = sum / 10 carry=sum/10. Create a new node with the digit
   * value of (sum \bmod 10)(summod10) and set it to current node's next, then advance current node
   * to next. Advance both pp and qq. Check if carry = 1carry=1, if so append a new node with digit
   * 11 to the returning list. Return dummy head's next node.
   */
  public static Node addTwoNumbers(Node l1, Node l2) {
    Node dummyHead = new Node(0, null);

    Node p = l1;
    Node q = l2;
    Node curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {

      int x = (p != null) ? p.data : 0;
      int y = (q != null) ? q.data : 0;

      // Add two number and carry
      int sum = carry + x + y;
      // Calculate new carry;
      carry = sum / 10;
      curr.next = new Node(sum % 10, null);
      curr = curr.next;
      // Increment both Linked list if not null
      if (p != null) {
        p = p.next;
      }
      if (q != null) {
        q = q.next;
      }
    }
    if (carry > 0) {
      curr.next = new Node(carry, null);
    }
    return dummyHead.next;
  }
}

