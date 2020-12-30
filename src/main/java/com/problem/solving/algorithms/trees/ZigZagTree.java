package com.problem.solving.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Given a binary tree, return the zigzag level order traversal of its nodes' values.
     3
   / \
  9  20
    /  \
   15   7

Output ::
          [3],
          [20,9],
          [15,7]
https://medium.com/@harycane/binary-tree-zigzag-level-order-traversal-5b96a3e1b767
 */
public class ZigZagTree {

    /* Since each node is visited at least once
        Time complexity O(n)
       Since queue can contain all leaf nodes in the worst case, the
        Space complexity O(n)

        1. An ideal approach to follow for ZigZag Level Order Traversal is the Breadth First Approach as
        followed in the Level Order Traversal. Add the root node, which is the first visited node, to a
        Queue whose each element takes a Tree Node data structure as the input.

        2. Iterate until the contents of the queue is empty, resetting the ‘level’ list at each level
        to a new empty list. For each level, poll the visited element from the Queue. Maintain a
        boolean flag variable that toggles between false and true for left to right and right to left
        traversal. For left to right traversal, flag is false, in which case simply add the polled
        node’s value to the ‘level’ list, used for tracking the list of values in each particular
        level. For right to left traversal, flag is true, in which case add the polled node’s value
        at the 0th index of the ‘level’ list.
       3. Once a visited node’s value has been added to level list, explore it’s neighbors,
          i.e. its left and right children, by adding them on to the queue, if they exist.
       4. Once an entire level of nodes have been visited, add the level list to the final result list.
         Toggle the flag’s boolean value to achieve zig zag level order traversing.
         Continue to
         iterate the aforementioned steps until the queue is completely empty.

     */

    public static List<List<Integer>> zigZagOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // Declare queue
        Queue<TreeNode> queue = new LinkedList<>();
        boolean zigZag = false;
        if (root == null) {
            return result;
        }

        // Add root node in queue
        queue.offer(root);

        // Traverse queue until it's not empty
        while (!queue.isEmpty()) {
            // Declare level list and size from queue
            List<Integer> level = new ArrayList<>();
            int sizeQueue = queue.size();
            for (int i = 0; i < sizeQueue; i++) {
                TreeNode node = queue.poll();

                if (zigZag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
            zigZag = !zigZag;
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = zigZagOrder(root);
        for (List<Integer> res : result) {
            for (Integer i : res) {
                System.out.print(i + " ");
            }
        }
    }

}
