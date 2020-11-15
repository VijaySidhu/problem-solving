package com.problem.solving.algorithms.linkedlist;

/*
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Complexity Analysis:
      Time Complexity: O(m + n), where m and n are number of nodes
      in first and second lists respectively.The lists needs to be traversed only once.
      Space Complexity: O(m + n).
      A temporary linked list is needed to store the output number
 */
public class AddTwoNumbers {

  public static void main(String[] args) {
    // Input: l1 = [2,4,3], l2 = [5,6,4]
    Node l1 = new Node(2, new Node(4, new Node(3, null)));
    Node l2 = new Node(5, new Node(6, new Node(4, null)));
    Node result = AddTwoNumbers.addTwoNumbers(l1, l2);
    while (result != null) {
      System.out.println(result.getData());
      result = result.next;
    }
  }

  /*
    1. Traverse two linked list from start to end.
    2. Add two digits each from respective linked lists plus carry. If any list reached at end take 0;
    3. If sum of two digits is greater then 10 take carry as 1 and current digit as sum%10;
   */
  public static Node addTwoNumbers(Node l1, Node l2) {
    int carry = 0;
    Node dummyHead = new Node(0, null);
    Node current = dummyHead;

    while (l1 != null || l2 != null) {
      int x = (l1 != null) ? l1.getData() : 0;
      int y = (l2 != null) ? l2.getData() : 0;
      int sum = x + y + carry;
      carry = sum / 10;
      current.next = new Node(sum % 10, null);
      current = current.next;
      // Next index
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry > 0) {
      current.next = new Node(carry, null);
    }
    return dummyHead.next;
  }
}
