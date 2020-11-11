package com.problem.solving.algorithms.trees;

/*
   Binary search tree:
      1. Nodes of left subtrees are less than root
      2. Nodes of right subtree are greater than root
   Avg TC : O(h) h is height and h = (log2n) 2 is base so TC = O(logN) with base 2
   Worst Case : O(n)
   Best case : O(1)
   Red black tree is self balancing binary search tree. It takes
   maximum 2 rotations to balance it. Sometimes only recoloring is required
   and not rotations. It gurantees TC O(logN)
   Faster Insertion and deletion. Extra Coloring bit is used to ensure tree remains balanced after insertion and deletion.
   Although blalance is not perfect but it gurantees O(logN)
   Properties of Red Black Tree -->
     1. Self balancing with rotation and recoloring
     2. Every node is RED or BLACK
     3. ROOT is always black
     4. Every leaf which is NULL always BLACK
     5. If node is RED then children are black
     6. Every path from node to its descdent (NIL) node has same no. of black nodes.
     7. If parent is RED then children are black.
 */
public class RedBlackTree {

  // Balancing, Always try recoloring first if it doesn't work then rotation.
  /* Insertion Algorithm, Let's try to insert Node X and take color RED
     1. If X is root node then simply assign black color to it
     2. If X (Assigned RED) is not root and x's parent is not BLACK.
        Do the following ::
        A.) X's uncle is RED (Grandparent must be black)
            i.  Change the color of parent and uncle as black
            ii. Color of grandparent as RED.
            iii.Change x=x's grandparent, repeat steps 2 and 3 for new x.
        B.) If x's uncle is BLACK, then there can be four configurations
            for x, x's parent and grandparent.
           (i) Left Left Case (p is left child of g and x is left
           child of p)
          (ii) Left Right Case (p is left child of g and x is the
                right child of p)
          (iii) Right Right Case (Mirror of case i)
          (iv) Right Left Case (Mirror of case ii)
   */
}
