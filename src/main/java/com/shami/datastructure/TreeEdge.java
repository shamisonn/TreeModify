package com.shami.datastructure;

public class TreeEdge {
    private TreeNode parent; // parentは自分が親にとって右か、左か考える必要がある。
    private TreeNode child;  // childの右左は必ず隣人

    private boolean fix = false;

    public TreeEdge(TreeNode parent, TreeNode child) {
        this.parent = parent;
        this.child = child;
    }

    public void fix() {
        fix = true;
    }

    public boolean isFix() {
        return fix;
    }

    public boolean hasLeaf() {
        return child.isLeaf();
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode getChild() {
        return child;
    }
}
