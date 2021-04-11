package com.problem.solving.algorithms.trees;

import java.util.ArrayDeque;
//Given the root of a binary tree, return the sum of values of its deepest leaves.
// Leetcode 1302
public class DeepestLeaveSum {
    /**
     * Track current level and nextLevel.
     * Make next level as current level if next level is null during loop return it's sum
     * TC O(N)
     * SC O(n)
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque();
        ArrayDeque<TreeNode> currentLevel = new ArrayDeque();
        nextLevel.offer(root);
        while(!nextLevel.isEmpty()){
            currentLevel = nextLevel.clone();
            nextLevel.clear();
            for(TreeNode node: currentLevel){
                if(node.left!=null){
                    nextLevel.offer(node.left);
                }
                if(node.right!=null){
                    nextLevel.offer(node.right);
                }
            }
        }
        int deepestSum = 0;
        for(TreeNode node : currentLevel){
            deepestSum = deepestSum+node.val;
        }
        return deepestSum;

    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

}