package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/3/2018.
 */
public class NodeTri {

    private NodeTri left;

    private NodeTri middle;

    private NodeTri right;

    private int data;

    public NodeTri(int data) {
        this.data = data;
    }

    public NodeTri getLeft() {
        return left;
    }

    public void setLeft(NodeTri left) {
        this.left = left;
    }

    public NodeTri getMiddle() {
        return middle;
    }

    public void setMiddle(NodeTri middle) {
        this.middle = middle;
    }

    public NodeTri getRight() {
        return right;
    }

    public void setRight(NodeTri right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
