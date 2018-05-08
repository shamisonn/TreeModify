package com.shami.datastructure;

public class TreeNode {
    private TreeNode parent;
    private TreeNode rightChild;
    private TreeNode leftChild;

    private TreeEdge parentEdge;
    private TreeEdge rightEdge;
    private TreeEdge leftEdge;

    private boolean isLeaf;
    private String label;

    public TreeNode(TreeNode parent) {
        this.parent = parent;
        this.rightChild = null;
        this.leftChild = null;
        this.isLeaf = false;
    }

    // setter
    public void beLeaf() {
        this.isLeaf = true;
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

    @Override
    public String toString() {
        if (this.isLeaf) {
            return this.label;
        } else {
            return "(" + this.leftChild + "," + this.rightChild + ")";
        }
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeEdge getParentEdge() {
        return parentEdge;
    }

    public void setParentEdge(TreeEdge parentEdge) {
        this.parentEdge = parentEdge;
    }

    public TreeEdge getRightEdge() {
        return rightEdge;
    }

    public void setRightEdge(TreeEdge rightEdge) {
        this.rightEdge = rightEdge;
    }

    public TreeEdge getLeftEdge() {
        return leftEdge;
    }

    public void setLeftEdge(TreeEdge leftEdge) {
        this.leftEdge = leftEdge;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public TreeNode copy(TreeNode parent) {
        TreeNode cp = new TreeNode(parent);
        cp.setLeaf(this.isLeaf);
        cp.setLabel(this.label);

        cp.setLeftChild(this.leftChild.copy(cp));
        cp.setRightChild(this.rightChild.copy(cp));

        cp.setParentEdge(new TreeEdge(parent, cp));
        cp.setRightEdge(new TreeEdge(parent, cp.getRightChild()));
        cp.setLeftEdge(new TreeEdge(parent, cp.getLeftChild()));

        return cp;
    }
}
