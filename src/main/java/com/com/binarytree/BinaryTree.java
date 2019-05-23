package com.com.binarytree;

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode('A');
        binaryTree.initialize(root);
        binaryTree.inorderTraversal(root);
        binaryTree.preorderTraversal(root);
        binaryTree.postorderTraversal(root);
    }

    private void postorderTraversal(TreeNode root) {
        System.out.println("Preorder  traversal: ");
        postorder(root);
    }

    private void postorder(TreeNode root) {
        if (root != null) {
            preorder(root.getLeft());
            preorder(root.getRight());
            System.out.println(root.data());
        }
    }

    private void preorderTraversal(TreeNode root) {
        System.out.println("Preorder  traversal: ");
        preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.data());
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    private void inorderTraversal(TreeNode root) {
        System.out.println("Inorder  traversal: ");
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.println(root.data());
            inorder(root.getRight());
        }
    }

    private void initialize(TreeNode root) {
        TreeNode leftSubTree = new TreeNode('B');
        TreeNode rightSubTree = new TreeNode('C');
        root.setLeft(leftSubTree);
        root.setRight(rightSubTree);
        TreeNode leftLeaf = new TreeNode('D');
        leftSubTree.setLeft(leftLeaf);
        TreeNode rightLeaf = new TreeNode('E');
        rightSubTree.setRight(rightLeaf);
    }
}

