package com.shami.modify;

import com.shami.datastructure.TreeEdge;
import com.shami.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeModifier {
    List<TreeEdge> edges;

    public TreeModifier(TreeNode tree) {
        this.edges = edgesSetting(tree);
    }

    private List<TreeEdge> edgesSetting(TreeNode tree) {
        return makeEdges(tree, null);
    }

    private List<TreeEdge> makeEdges(TreeNode node, TreeEdge parent) {
        List<TreeEdge> edges = new ArrayList<>();
        if(node.isLeaf()) {
            return edges;
        }
        // set parent edge
        if (!node.isRoot()) {
            node.setParentEdge(parent);
        }
        // make left and set
        TreeEdge left = new TreeEdge(node, node.getLeftChild());
        edges.add(left);
        node.setLeftEdge(left);
        // make right and set
        TreeEdge right = new TreeEdge(node, node.getRightChild());
        edges.add(right);
        node.setRightEdge(right);

        // make children edges
        List<TreeEdge> leftEdges = makeEdges(node.getLeftChild(), left);
        List<TreeEdge> rightEdges = makeEdges(node.getRightChild(), right);

        if (leftEdges.size() != 0) {
            edges.addAll(leftEdges);
        }
        if (rightEdges.size() != 0) {
            edges.addAll(rightEdges);
        }

        return edges;
    }

    public TreeNode modify(TreeEdge e, boolean doLeftChange) {

        return null;
    }
}
