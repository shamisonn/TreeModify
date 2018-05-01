package com.shami.datastructure;

public class TreeNode {
    private TreeNode parent;
    private TreeNode rightChild;
    private TreeNode leftChild;

    private boolean isLeaf;
    private String label;

    public TreeNode(TreeNode parent) {
        this.parent = parent;
        this.rightChild = null;
        this.leftChild = null;
        this.isLeaf = false;
    }

    // setter
    public void beLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public boolean isLeaf() {
        return this.isLeaf;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isRightEmpty() {
        return this.rightChild == null;
    }

    public boolean isLeftEmpty() {
        return this.leftChild == null;
    }

    public boolean isFill() {
        return (this.rightChild == null) && (this.leftChild == null);
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }
}
