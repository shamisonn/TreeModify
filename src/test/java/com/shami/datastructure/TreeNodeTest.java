package com.shami.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeNodeTest {

    @Test
    void toStringTest1() {
        // (1,(3,4));
        TreeNode root = new TreeNode(null);
        TreeNode n1 = new TreeNode(root);
        TreeNode n2 = new TreeNode(root);
        TreeNode n3 = new TreeNode(n2);
        TreeNode n4 = new TreeNode(n2);

        root.setLeftChild(n1);
        root.setRightChild(n2);

        n1.setLabel("1");
        n1.beLeaf();

        n2.setLeftChild(n3);
        n2.setRightChild(n4);

        n3.setLabel("3");
        n3.beLeaf();

        n4.setLabel("4");
        n4.beLeaf();

        assertEquals("(1,(3,4))", root.toString());
    }
    @Test
    void toStringTest2() {
        // (1,((5,6),4));
        TreeNode root = new TreeNode(null);
        TreeNode n1 = new TreeNode(root);
        TreeNode n2 = new TreeNode(root);
        TreeNode n3 = new TreeNode(n2);
        TreeNode n4 = new TreeNode(n2);
        TreeNode n5 = new TreeNode(n3);
        TreeNode n6 = new TreeNode(n3);

        root.setLeftChild(n1);
        root.setRightChild(n2);

        n1.setLabel("1");
        n1.beLeaf();

        n2.setLeftChild(n3);
        n2.setRightChild(n4);

        n3.setLeftChild(n5);
        n3.setRightChild(n6);

        n4.setLabel("4");
        n4.beLeaf();

        n5.setLabel("5");
        n5.beLeaf();

        n6.setLabel("6");
        n6.beLeaf();

        assertEquals("(1,((5,6),4))", root.toString());
    }
}
