package com.problem.solving.algorithms.trees;

/*
   Binary search tree:
      1. Nodes of left subtrees are less than root
      2. Nodes of right subtree are greater than root
   Avg TC : O(h) h is height and h = (log2n) 2 is base so TC = O(logn) with base 2
   Worst Case : O(n)
   Best case : O(1)
   Red black tree is self balancing binary search tree. It takes
   maximum 2 rotations to balance it. Sometimes only recoloring is required
   and not rotations. It gurantees TC O(log2N)
   Faster Insertion and deletion.
   Properties of Red Black Tree -->
     1. Self balancing with rotation and recoloring
     2. Every node is RED or BLACK
     3. ROOT is always black
     4. Every leaf which is NULL always BLACK
     5. If node is RED then children are black
     6. Every path from node to its descdent (NIL) node has same no. of black nodes.
 */
public class RedBlackTree {

}
