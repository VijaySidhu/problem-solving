package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/2/2018.
 */
public class SpiralForm {

    public static void zigZagPrinter(Node root) {
        int height = HeightOfTree.height(root);
        boolean switchOrder = false;
        for (int i = 0; i <= height; i++) {
            printInZigZagOrSpiral(root, switchOrder, i);
            switchOrder = !switchOrder;
        }
    }

    public static void printInZigZagOrSpiral(Node root, boolean switchOrder, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.getData() + " ");
        } else if (level > 1) {
            if (switchOrder) {
                printInZigZagOrSpiral(root.getLeft(), switchOrder, level - 1);
                printInZigZagOrSpiral(root.getRight(), switchOrder, level - 1);
            } else {
                printInZigZagOrSpiral(root.getRight(), switchOrder, level - 1);
                printInZigZagOrSpiral(root.getLeft(), switchOrder, level - 1);
            }
        }

    }
}
