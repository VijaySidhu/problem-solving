package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 1/31/2018.
 * Given an array that represents a tree in such a way that array indexes are values in tree nodes and array values
 * give the parent node of that particular index (or node). The value of the root node index would always be -1 as
 * there is no parent for root.
 * Construct the standard linked representation of given Binary Tree from this given representation.
 * Input: parent[] = {1, 5, 5, 2, 2, -1, 3}
 * Output
 * 5
 * /  \
 * 1    2
 * /    / \
 * 0    3   4
 * /
 * 6
 */
public class TreeFromArray {
    /**
     * Create an array of pointers say created[0..n-1]. Value of created[i] is null if node is not created for given index
     * Do following for every index
     * createNode(paren,i,created)
     */
    private static Node root;

    // Creates a node with key as 'i'.  If i is root, then it changes
    // root.  If parent of i is not created, then it creates parent first
   public static void createNode(int parent[], int i, Node created[]) {
        // If this node is already created
        if (created[i] != null)
            return;

        // Create a new node and set created[i]
        created[i] = new Node(i,null,null);

        // If 'i' is root, change root pointer and return
        if (parent[i] == -1) {
            root = created[i];
            return;
        }

        // If parent is not created, then create parent first
        if (created[parent[i]] == null)
            createNode(parent, parent[i], created);

        // Find parent pointer
        Node p = created[parent[i]];

        // If this is first child of parent
        if (p.getLeft() == null)
            p.setLeft(created[i]);
        else // If second child

            p.setRight(created[i]);
    }

    /* Creates tree from parent[0..n-1] and returns root of
       the created tree */
    public static Node createTree(int parent[], int n) {
        // Create an array created[] to keep track
        // of created nodes, initialize all entries
        // as NULL
        Node[] created = new Node[n];
        for (int i = 0; i < n; i++)
            created[i] = null;

        for (int i = 0; i < n; i++)
            createNode(parent, i, created);

        return root;
    }
}
