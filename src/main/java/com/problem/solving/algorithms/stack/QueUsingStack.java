package com.problem.solving.algorithms.stack;

import java.util.Stack;

/**
 * Time Complexity: Push operation: O(1). Same as pop operation in stack. Pop operation: O(N). In
 * the worst case we have empty whole of stack 1 into stack 2 Auxiliary Space: O(N). Use of stack
 * for storing values.
 * <p>
 * enQueue(q,  x) 1) Push x to stack1 (assuming size of stacks is unlimited). Here time complexity
 * will be O(1)
 * <p>
 * deQueue(q) 1) If both stacks are empty then error. 2) If stack2 is empty While stack1 is not
 * empty, push everything from stack1 to stack2. 3) Pop the element from stack2 and return it. Here
 * time complexity will be O(n)
 */
public class QueUsingStack {

  /* class of queue having two stacks */
  static class Queue {

    Stack<Integer> stack1;

    Stack<Integer> stack2;
  }

  /* Function to push an item to stack*/
  static void push(Stack<Integer> top_ref, int new_data) {
    // Push the data onto the stack
    top_ref.push(new_data);
  }

  /* Function to pop an item from stack*/
  static int pop(Stack<Integer> top_ref) {
    /*If stack is empty then error */
    if (top_ref.isEmpty()) {
      System.out.println("Stack Underflow");
      System.exit(0);
    }

    // pop the data from the stack
    return top_ref.pop();
  }

  // Function to enqueue an item to the queue
  static void enQueue(Queue q, int x) {
    push(q.stack1, x);
  }

  /* Function to deQueue an item from queue */
  static int deQueue(Queue q) {
    int x;

    /* If both stacks are empty then error */
    if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
      System.out.println("Q is empty");
      System.exit(0);
    }

        /* Move elements from stack1 to stack 2 only if
        stack2 is empty */
    if (q.stack2.isEmpty()) {
      while (!q.stack1.isEmpty()) {
        x = pop(q.stack1);
        push(q.stack2, x);
      }
    }
    x = pop(q.stack2);
    return x;
  }

  /* Driver function to test above functions */
  public static void main(String args[]) {
    /* Create a queue with items 1 2 3*/
    Queue q = new Queue();
    q.stack1 = new Stack<>();
    q.stack2 = new Stack<>();
    enQueue(q, 1);
    enQueue(q, 2);
    enQueue(q, 3);

    /* Dequeue items */
    System.out.print(deQueue(q) + " ");
    System.out.print(deQueue(q) + " ");
    System.out.println(deQueue(q) + " ");
  }
}
