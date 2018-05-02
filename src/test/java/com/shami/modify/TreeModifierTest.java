package com.shami.modify;

import com.shami.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeModifierTest {
    @DisplayName("makeEdgesTest: (1,(3,4));")
    @Test
    void makeEdgesTest() {
        // (1,(3,4));
        TreeNode root = new TreeNode(null);
        root.setLabel("root");
        TreeNode n1 = new TreeNode(root);
        n1.setLabel("1");
        TreeNode n2 = new TreeNode(root);
        n2.setLabel("2");
        TreeNode n3 = new TreeNode(n2);
        n3.setLabel("3");
        TreeNode n4 = new TreeNode(n2);
        n4.setLabel("4");

        root.setLeftChild(n1);
        n1.beLeaf();

        root.setRightChild(n2);

        n2.setLeftChild(n3);
        n3.beLeaf();

        n2.setRightChild(n4);
        n4.beLeaf();

        TreeModifier modifier = new TreeModifier(root);
        // root = modifier.getTree();

        // root: root
        assertEquals(root.getLeftEdge().getParent().getLabel(), "root");
        assertEquals(root.getLeftEdge().getChild().getLabel(), "1");
        assertEquals(root.getRightEdge().getParent().getLabel(), "root");
        assertEquals(root.getRightEdge().getChild().getLabel(), "2");

        // n1: leaf
        // n1 = root.getLeftChild();
        assertEquals(n1.getParentEdge().getParent().getLabel(), "root");
        assertEquals(n1.getParentEdge().getChild().getLabel(), "1");

        // n2: node
        // n2 = root.getRightChild();
        assertEquals(n2.getParentEdge().getParent().getLabel(), "root");
        assertEquals(n2.getParentEdge().getChild().getLabel(), "2");
        assertEquals(n2.getLeftEdge().getParent().getLabel(), "2");
        assertEquals(n2.getLeftEdge().getChild().getLabel(), "3");
        assertEquals(n2.getRightEdge().getParent().getLabel(), "2");
        assertEquals(n2.getRightEdge().getChild().getLabel(), "4");

        // n3: leaf
        // n3 = n2.getLeftChild();
        assertEquals(n3.getParentEdge().getParent().getLabel(), "2");
        assertEquals(n3.getParentEdge().getChild().getLabel(), "3");

        // n4: leaf
        // n4 = n2.getRightChild();
        assertEquals(n4.getParentEdge().getParent().getLabel(), "2");
        assertEquals(n4.getParentEdge().getChild().getLabel(), "4");
    }
}
