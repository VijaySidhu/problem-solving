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
public class RedBlackTree<T extends Comparable<T>> implements Iterable<T> {

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
  /*
    Jenni's Lecture :: https://www.youtube.com/watch?v=qA02XWRTBdw&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF
        1. If Tree is empty, create new node as root node with Black color.
        2. If Tree is not empty create leaf node with Red color.
        3. If parent of new node is black then exit.
        4. If parent of new node is RED, then check the color of parent's
           sibling of new node.
             a.) If color is black or null then recolor
             b.) If color is RED then recolor and also check if parent's
                 parent of new node is not root node then recolor it and recheck.

   */

  public static final boolean RED = true;

  public static final boolean BLACK = false;

  // The root node of the RB tree.
  public Node root;

  // Tracks the number of nodes inside the tree.
  private int nodeCount = 0;

  // Example usage of RB tree:
  public static void main(String[] args) {

    int[] values = {5, 8, 1, -4, 6, -2, 0, 7};
    RedBlackTree<Integer> rbTree = new RedBlackTree<>();
    for (int v : values) {
      rbTree.insert(v);
    }

    System.out.printf("RB tree contains %d: %s\n", 6, rbTree.contains(6));
    System.out.printf("RB tree contains %d: %s\n", -5, rbTree.contains(-5));
    System.out.printf("RB tree contains %d: %s\n", 1, rbTree.contains(1));
    System.out.printf("RB tree contains %d: %s\n", 99, rbTree.contains(99));
  }

  // Returns the number of nodes in the tree.
  public int size() {
    return nodeCount;
  }

  // Returns whether or not the tree is empty.
  public boolean isEmpty() {
    return size() == 0;
  }

  public boolean contains(T value) {

    Node node = root;

    if (node == null || value == null) {
      return false;
    }

    while (node != null) {

      // Compare current value to the value in the node.
      int cmp = value.compareTo(node.value);

      // Dig into left subtree.
      if (cmp < 0) {
        node = node.left;
      }

      // Dig into right subtree.
      else if (cmp > 0) {
        node = node.right;
      }

      // Found value in tree.
      else {
        return true;
      }
    }

    return false;
  }

  public boolean insert(T value) {

    if (value == null) {
      throw new IllegalArgumentException();
    }

    // No root node.
    if (root == null) {
      root = new Node(value, null);
      insertionRelabel(root);
      nodeCount++;
      return true;
    }

    for (Node node = root; ; ) {

      int cmp = value.compareTo(node.value);

      // Left subtree.
      if (cmp < 0) {
        if (node.left == null) {
          node.left = new Node(value, node);
          insertionRelabel(node.left);
          nodeCount++;
          return true;
        }
        node = node.left;

        // Right subtree.
      } else if (cmp > 0) {
        if (node.right == null) {
          node.right = new Node(value, node);
          insertionRelabel(node.right);
          nodeCount++;
          return true;
        }
        node = node.right;

        // The value we're trying to insert already exists in the tree.
      } else {
        return false;
      }
    }
  }

  private void insertionRelabel(Node node) {

    Node parent = node.parent;

    // Root node case.
    if (parent == null) {
      node.color = BLACK;
      root = node;
      return;
    }

    Node grandParent = parent.parent;
    if (grandParent == null) {
      return;
    }

    // The red-black tree invariant is already satisfied.
    if (parent.color == BLACK || node.color == BLACK) {
      return;
    }

    boolean nodeIsLeftChild = (parent.left == node);
    boolean parentIsLeftChild = (parent == grandParent.left);
    Node uncle = parentIsLeftChild ? grandParent.right : grandParent.left;
    boolean uncleIsRedNode = (uncle == null) ? BLACK : uncle.color;

    if (uncleIsRedNode) {

      parent.color = BLACK;
      grandParent.color = RED;
      uncle.color = BLACK;

      // At this point the parent node is red and so is the new child node.
      // We need to re-balance somehow because no two red nodes can be
      // adjacent to one another.
    } else {

      // Parent node is a left child.
      if (parentIsLeftChild) {

        // Left-left case.
        if (nodeIsLeftChild) {
          grandParent = leftLeftCase(grandParent);

          // Left-right case.
        } else {
          grandParent = leftRightCase(grandParent);
        }

        // Parent node is a right child.
      } else {

        // Right-left case.
        if (nodeIsLeftChild) {
          grandParent = rightLeftCase(grandParent);

          // Right-right case.
        } else {
          grandParent = rightRightCase(grandParent);
        }
      }
    }

    insertionRelabel(grandParent);
  }

  private void swapColors(Node a, Node b) {
    boolean tmpColor = a.color;
    a.color = b.color;
    b.color = tmpColor;
  }

  private Node leftLeftCase(Node node) {
    node = rightRotate(node);
    swapColors(node, node.right);
    return node;
  }

  private Node leftRightCase(Node node) {
    node.left = leftRotate(node.left);
    return leftLeftCase(node);
  }

  private Node rightRightCase(Node node) {
    node = leftRotate(node);
    swapColors(node, node.left);
    return node;
  }

  private Node rightLeftCase(Node node) {
    node.right = rightRotate(node.right);
    return rightRightCase(node);
  }

  private Node rightRotate(Node parent) {

    Node grandParent = parent.parent;
    Node child = parent.left;

    parent.left = child.right;
    if (child.right != null) {
      child.right.parent = parent;
    }

    child.right = parent;
    parent.parent = child;

    child.parent = grandParent;
    updateParentChildLink(grandParent, parent, child);

    return child;
  }

  private Node leftRotate(Node parent) {

    Node grandParent = parent.parent;
    Node child = parent.right;

    parent.right = child.left;
    if (child.left != null) {
      child.left.parent = parent;
    }

    child.left = parent;
    parent.parent = child;

    child.parent = grandParent;
    updateParentChildLink(grandParent, parent, child);

    return child;
  }

  // Sometimes the left or right child node of a parent changes and the
  // parent's reference needs to be updated to point to the new child.
  // This is a helper method to do just that.
  private void updateParentChildLink(Node parent, Node oldChild, Node newChild) {
    if (parent != null) {
      if (parent.left == oldChild) {
        parent.left = newChild;
      } else {
        parent.right = newChild;
      }
    }
  }

  // Helper method to find the leftmost node (which has the smallest value)
  private Node findMin(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  // Helper method to find the rightmost node (which has the largest value)
  private Node findMax(Node node) {
    while (node.right != null) {
      node = node.right;
    }
    return node;
  }

  // Returns as iterator to traverse the tree in order.
  @Override
  public java.util.Iterator<T> iterator() {

    final int expectedNodeCount = nodeCount;
    final java.util.Stack<Node> stack = new java.util.Stack<>();
    stack.push(root);

    return new java.util.Iterator<T>() {
      Node trav = root;

      @Override
      public boolean hasNext() {
        if (expectedNodeCount != nodeCount) {
          throw new java.util.ConcurrentModificationException();
        }
        return root != null && !stack.isEmpty();
      }

      @Override
      public T next() {

        if (expectedNodeCount != nodeCount) {
          throw new java.util.ConcurrentModificationException();
        }

        while (trav != null && trav.left != null) {
          stack.push(trav.left);
          trav = trav.left;
        }

        Node node = stack.pop();

        if (node.right != null) {
          stack.push(node.right);
          trav = node.right;
        }

        return node.value;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  public class Node {

    // The color of this node. By default all nodes start red.
    public boolean color = RED;

    // The value/data contained within the node.
    public T value;

    // The left, right and parent references of this node.
    public Node left, right, parent;

    public Node(T value, Node parent) {
      this.value = value;
      this.parent = parent;
    }
  }
}
