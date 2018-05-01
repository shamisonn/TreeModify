package com.shami.datastructure;

public class Edge {
    private TreeNode parent; // parentは自分が親にとって右か、左か考える必要がある。
    private TreeNode child;  // childの右左は必ず隣人

    private boolean fix = false;

    public Edge(TreeNode parent, TreeNode child) {
        this.parent = parent;
        this.child = child;
    }

    public void fix() {
        fix = true;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode getChild() {
        return child;
    }
}
