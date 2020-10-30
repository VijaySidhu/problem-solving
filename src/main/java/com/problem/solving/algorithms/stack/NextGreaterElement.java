package com.problem.solving.algorithms.stack;

import java.util.Stack;

/**
 * Push the first element to stack. Pick rest of the elements one by one and follow the following
 * steps in loop. Mark the current element as next. If stack is not empty, compare top element of
 * stack with next. If next is greater than the top element,Pop element from stack. next is the next
 * greater element for the popped element. Keep popping from the stack while the popped element is
 * smaller than next. next becomes the next greater element for all such popped elements Finally,
 * push the next in the stack. After the loop in step 2 is over, pop all the elements from stack and
 * print -1 as next element for them. Time Complexity: O(n).
 */
public class NextGreaterElement {

  /* prints element and NGE pair for
       all elements of arr[] of size n */
  static void printNGE(int arr[], int n) {
    int i = 0;
    Stack<Integer> s = new Stack();
    int currentElement, nextElement;

    /* push the first element to stack */
    s.push(arr[0]);

    // iterate for rest of the elements
    for (i = 1; i < n; i++) {
      nextElement = arr[i];

      if (s.isEmpty() == false) {

        // if stack is not empty, then
        // pop an element from stack
        currentElement = s.pop();

                /* If the popped element is smaller than
                   next, then a) print the pair b) keep
                   popping while elements are smaller and
                   stack is not empty */
        while (currentElement < nextElement) {
          System.out.println(currentElement + " --> " + nextElement);
          if (s.isEmpty() == true) {
            break;
          }
          currentElement = s.pop();
        }

                /* If element is greater than next, then
                   push the element back */
        if (currentElement > nextElement) {
          s.push(currentElement);
        }
      }

            /* push next to stack so that we can find next
               greater for it */
      s.push(nextElement);
    }

        /* After iterating over the loop, the remaining
           elements in stack do not have the next greater
           element, so print -1 for them */
    while (s.isEmpty() == false) {
      currentElement = s.pop();
      nextElement = -1;
      System.out.println(currentElement + " -- " + nextElement);
    }
  }

  public static void main(String[] args) {
    int arr[] = {11, 13, 21, 3};
    int n = arr.length;
    printNGE(arr, n);
  }

}
