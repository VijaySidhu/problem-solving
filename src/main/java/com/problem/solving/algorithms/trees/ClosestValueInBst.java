package com.problem.solving.algorithms.trees;

import com.problem.solving.algorithms.ProblemSolverUtils;
// Leetcode 270
public class ClosestValueInBst {

    /*
    Iterative
    TC O(H)
    SC O(1)
     */
    public static int closestValue(NodeBST root, double target){
        int value;
        int closest = root.key;
        while(root!=null){
            value = root.key;
            closest = Math.abs(value-target)<Math.abs(closest-target) ? value : closest;
            if(target<closest && root.left!=null){
                root = root.left;

            }else if(target>closest && root.right!=null){
                root = root.right;
            }
        }
        return closest;
    }

    /*
       Average: O(log(n) time | Space O(log(n)
       Worst: O(n) time | O(n) space
     */
    public static int findClosestValueInBst(NodeBST node, int target, int closest) {

        if (Math.abs(target - closest) > Math.abs(target - node.key)) {
            return node.key;
        }
        // if Target is less than root data then recurse in left subtree
        if (target < node.key && node.left != null) {
            return findClosestValueInBst(node.left, target, closest);
        } else if (target > node.key && node.right != null) {
            return findClosestValueInBst(node.right, target, closest);
        } else {
            return closest;
        }

    }

    public static void main(String[] args) {

       /* Node root = ProblemSolverUtils.createBinarySearchTree();
        System.out.println(findClosestValueInBst(root, 11, root.getData()));*/
        NodeBST root = newnode(9);
        root.left = newnode(4);
        root.right = newnode(17);
        root.left.left = newnode(3);
        root.left.right = newnode(6);
        root.left.right.left = newnode(5);
        root.left.right.right = newnode(7);
        root.right.right = newnode(22);
        root.right.right.left = newnode(20);
        System.out.println(findClosestValueInBst(root, 20, root.key));
    }

    static class NodeBST {
        int key;
        NodeBST left;
        NodeBST right;
    }

    static NodeBST newnode(int key) {

        NodeBST node = new NodeBST();
        node.key = key;
        node.left = node.right = null;
        return (node);
    }

}
