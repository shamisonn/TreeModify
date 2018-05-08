package com.shami.modify;

import com.shami.datastructure.ModifyOperations;
import com.shami.datastructure.TreeEdge;
import com.shami.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TreeModifier {
    private TreeNode originalTree;
    private TreeNode tree;
    private List<TreeEdge> edges;
    private List<Integer> edgesMapping;
    private Random random;

    private int nniNumber;
    private ModifyOperations operations;


    public TreeModifier(TreeNode tree, int nni) {
        this.originalTree = tree.copy(null);
        this.tree = tree;
        this.edges = edgesSetting(tree);
        this.filterEdge();
        this.edgesMappingSetting();
        random = new Random();

        this.nniNumber = nni;
        this.operations = new ModifyOperations(nni);
    }

    private List<TreeEdge> edgesSetting(TreeNode tree) {
        return makeEdges(tree, null);
    }

    private List<TreeEdge> makeEdges(TreeNode node, TreeEdge parent) {
        // set parent edge
        if (!node.isRoot()) {
            node.setParentEdge(parent);
        }

        List<TreeEdge> edges = new ArrayList<>();
        if(node.isLeaf()) {
            return edges;
        }

        // make left and set
        TreeEdge left = new TreeEdge(node, node.getLeftChild(), true);
        edges.add(left);
        node.setLeftEdge(left);
        // make right and set
        TreeEdge right = new TreeEdge(node, node.getRightChild(), false);
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

    private void filterEdge() {
        this.edges = this.edges
                .stream()
                .filter(e -> !e.hasLeaf())
                .collect(Collectors.toList());
    }

    // 1, 2, 3,..., edges.size() までの対応関係を表す。
    private void edgesMappingSetting() {
        this.edgesMapping = new ArrayList<>();
        for (int i = 0; i < this.edges.size(); i++) {
            edgesMapping.add(i + 1);
        }
    }


    // repNum: 反復回数, NNIをやる数, 1 ~ 5
    public String modify() {
        this.resetTree();
        int[] operation = new int[this.nniNumber];
        for (int i = 0; i < this.nniNumber; i++) {
            int idx = getUnFixedEdge();
            if (idx == 0) {
                System.err.println("[ERR] all edges fixed!");
                System.exit(1);
            }
            TreeEdge edge = this.edges.get(idx-1);
            boolean doLeftChange = this.random.nextBoolean();
            this.modify(edge, doLeftChange);
            edge.fix();
            if (doLeftChange) {
                operation[i] = idx;
            } else {
                operation[i] = idx * -1;
            }
        }
        if(this.isOperatedBefore(operation)) {
            // retry!
            return this.modify();
        }
        return this.modifiedTreeString();
    }

    // 過去に操作したことがあるかどうか。
    private boolean isOperatedBefore(int[] op) {
        if(!this.operations.isContain(op)) {
            this.operations.addOperation(op);
            return false;
        }
        return true;
    }

    // 一度だけ木を変更する
    // warning: use if only and if leaf num = 10 and NNI = 1 .
    public String[] modifyOnce() {
        String[] trees = new String[2];
        int i = getUnFixedEdge();
        if (i == 0) {
            System.err.println("[ERR] all edges fixed!");
            System.exit(1);
        }

        TreeEdge edge = edges.get(i-1);

        this.modify(edge, true);
        trees[0] = this.modifiedTreeString();
        this.resetTree();

        this.modify(edge, false);
        trees[1] = this.modifiedTreeString();
        this.resetTree();

        edge.fix();

        return trees;
    }

    private int getUnFixedEdge() {
        Collections.shuffle(this.edgesMapping);
        for (int i: edgesMapping) {
            TreeEdge edge = edges.get(i-1);
            if (!edge.isFix() && !edge.hasLeaf())
                return i;
        }
        return 0;
    }

    private void modify(TreeEdge e, boolean doLeftChange) {
        assert !e.hasLeaf();

        TreeNode eParent = e.getParent();
        TreeNode eChild = e.getChild();

        // 子供のNode: eChild -> child
        TreeNode child;
        if (doLeftChange) {
            child = eChild.getLeftChild();
        } else {
            child = eChild.getRightChild();
        }

        // 兄弟のNode: eParent -> bro
        TreeNode bro;
        if (e.isSlopePositive()) {
            bro = eParent.getRightChild();
        } else {
            bro = eParent.getLeftChild();
        }

        // eChild -> bro
        if (doLeftChange) {
            eChild.setLeftChild(bro);
            eChild.getLeftEdge().setChild(bro);
        } else {
            eChild.setRightChild(bro);
            eChild.getRightEdge().setChild(bro);
        }
        bro.setParent(eChild);
        bro.getParentEdge().setParent(eChild);

        // eParent -> child
        if (e.isSlopePositive()) {
            eParent.setRightChild(child);
            eParent.getRightEdge().setChild(child);
        } else {
            eParent.setLeftChild(child);
            eParent.getLeftEdge().setChild(child);
        }
        child.setParent(eParent);
        child.getParentEdge().setParent(eParent);

    }


    public void resetTree() {
        this.tree = this.originalTree.copy(null);
    }

    public String modifiedTreeString() {
        return this.tree.toString();
    }

    public TreeNode getTree() {
        return tree;
    }

    public List<TreeEdge> getEdges() {
        return edges;
    }
}
