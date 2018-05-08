package com.shami.datastructure;

public class TreeEdge {
    private TreeNode parent; // parentは自分が親にとって右か、左か考える必要がある。
    private TreeNode child;  // childの右左は必ず隣人

    private boolean fix = false;

    private boolean isSlopePositive;

    // / -> positive
    // \ -> negative
    public TreeEdge(TreeNode parent, TreeNode child, boolean isSlopePositive) {
        this.parent = parent;
        this.child = child;
        this.isSlopePositive = isSlopePositive;
    }

    public TreeEdge(TreeNode parent, TreeNode child) {
        new TreeEdge(parent, child, true);
    }

    public void fix() {
        fix = true;
    }

    public boolean isFix() {
        return fix;
    }

    public boolean isSlopePositive() {
        return isSlopePositive;
    }

    public boolean hasLeaf() {
        return child.isLeaf();
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void setChild(TreeNode child) {
        this.child = child;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode getChild() {
        return child;
    }
}
