package com.com.binarytree;

public class TreeNode {
    private char aChar;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(char aChar) {
        this.aChar = aChar;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public char data() {
        return aChar;
    }
}
