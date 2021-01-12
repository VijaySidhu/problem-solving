package com.problem.solving.algorithms.trees.practice;

import java.util.List;

public class DeepCopyOfNryTree {

    public static Node cloneTree(Node root) {
        if (root == null) return null;
        Node copy = new Node(root.val);
        for (Node child : root.children)
            copy.children.add(cloneTree(child));
        return copy;
    }

    private static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
        }
    }
}
