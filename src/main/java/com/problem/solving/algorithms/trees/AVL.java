package com.problem.solving.algorithms.trees;

/*
   It is a self balancing bst where the difference between heights of left and right
   subtrees are {0,-1,1}
 */
public class AVL {

  private Node root;

  /*
        1. Perform regular bst insert
        2. Current node must be one of the ancestor of newly inserted node.
           Update height of current node.
        3. Get Balance factor of current node. (Height of left subtree-Height of right subtree).
        4. If balance factor is greater that 1, then we are in left left case
           or left right case. To select case between two compare key of new node with key of left root
        5. If balance factor is less than 1, then we are in right right case
           or right left case. To select case between two compare key of new node with key of the root of right subtree
     */
  // TC for insert,delete and search O(LogN)
  // Space O(N)
  public static void main(String[] args) {
    AVL tree = new AVL();
    /* Constructing tree given in the above figure */
    tree.root = tree.insert(tree.root, 10);
    tree.root = tree.insert(tree.root, 20);
    tree.root = tree.insert(tree.root, 30);
    tree.root = tree.insert(tree.root, 40);
    tree.root = tree.insert(tree.root, 50);
    tree.root = tree.insert(tree.root, 25);
      /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
    System.out.println("Preorder traversal" +
        " of constructed tree is : ");
    tree.preOrder(tree.root);
  }

  void preOrder(Node node) {
    if (node != null) {
      System.out.print(node.key + " ");
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  Node insert(Node node, int key) {
    // Perform BST insertion
    if (node == null) {
      node = new Node(key);
      return node;
    }
    //if key is less than node key then traverse left subtree
    if (key < node.getKey()) {
      node.setLeft(insert(node.getLeft(), key));
    }
    // Recurse right
    else if (key > node.getKey()) {
      node.setRight(insert(node.getRight(), key));
    } else {
      return node; // Duplicates are not allowed in BST
    }

    // Update height of this ancestor node
    node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

    // Calculate balance factor
    int balance = getBalance(node);
    // If balance is greater than 1 and left tree node is greater than key then
    // Right rotate
    if (balance > 1 && key < node.getLeft().getKey()) {
      return rightRotate(node);
    }
    // Left Right Case
    if (balance > 1 && key > node.left.key) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    // Right Right Case
    if (balance < -1 && key > node.right.key) {
      return leftRotate(node);
    }
    // Right Left Case
    if (balance < -1 && key < node.right.key) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }
    return node;
  }

  // Get balance factor of Node
  int getBalance(Node node) {
    if (node == null) {
      return 0;
    }
    return height(node.getLeft()) - height(node.getRight());
  }

  // Method for left rotation
  Node leftRotate(Node node) {
    Node rightOfNode = node.getRight();
    Node leftOfRightNode = rightOfNode.getLeft();
    // Perform rotation
    rightOfNode.setLeft(node);
    node.setRight(leftOfRightNode);

    // Update Height
    node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
    rightOfNode.setHeight(max(height(rightOfNode.getLeft()), height(rightOfNode.getRight())) + 1);
    return rightOfNode;
  }

  // Method to right rotate subtree
  Node rightRotate(Node node) {
    Node leftOfNode = node.getLeft();
    Node rightOfLeftNode = leftOfNode.getRight();
    // Perform rotation
    leftOfNode.setRight(node);
    node.setLeft(rightOfLeftNode);

    // Update Height
    node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
    leftOfNode.setHeight(max(height(leftOfNode.getLeft()), height(leftOfNode.getRight())) + 1);
    return leftOfNode;
  }

  // Method to get max of two nodes
  int max(int a, int b) {
    return (a > b) ? a : b;
  }

  // Method to get height of node
  int height(Node node) {
    if (node == null) {
      return 0;
    }
    return node.getHeight();
  }

  class Node {

    int key, height;

    Node left, right;

    Node(int d) {
      key = d;
      height = 1;
    }

    public int getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }

    public Node getLeft() {
      return left;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getRight() {
      return right;
    }

    public void setRight(Node right) {
      this.right = right;
    }
  }


}
