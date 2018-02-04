package com.problem.solving.algorithms.linkedlist;

/**
 * Created by VijaySidhu on 2/3/2018.
 */
public class NodeDoubly {

    private int data;
    private NodeDoubly left;
    private NodeDoubly right;

    public NodeDoubly() {
    }
    public NodeDoubly(int data) {
        this.data = data;
    }

    public NodeDoubly(int data, NodeDoubly left, NodeDoubly right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeDoubly getLeft() {
        return left;
    }

    public void setLeft(NodeDoubly left) {
        this.left = left;
    }

    public NodeDoubly getRight() {
        return right;
    }

    public void setRight(NodeDoubly right) {
        this.right = right;
    }
}
