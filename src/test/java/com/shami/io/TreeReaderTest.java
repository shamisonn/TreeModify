package com.shami.io;

import com.shami.datastructure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeReaderTest {

    @DisplayName("sample instance: (3,(1,2));")
    @Test
    void makeTreeTest1() {
        TreeReader tr = new TreeReader();
        TreeNode node = tr.makeTree("(3,(1,2));");

        assertEquals("3", node.getLeftChild().getLabel());
        assertEquals("1", node.getRightChild().getLeftChild().getLabel());
        assertEquals("2", node.getRightChild().getRightChild().getLabel());
    }

    @DisplayName("(1,((5,6),4));")
    @Test
    void makeTreeTest2() {
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

        TreeReader tr = new TreeReader();
        TreeNode node = tr.makeTree("(1,((5,6),4));");

        assertEquals(
                root.getLeftChild().getLabel(),
                node.getLeftChild().getLabel()
        );
        assertEquals(
                root.getLeftChild().getLabel(),
                "1"
        );

        assertEquals(
                root.getRightChild().getRightChild().getLabel(),
                node.getRightChild().getRightChild().getLabel()
        );
        assertEquals(
                root.getRightChild().getRightChild().getLabel(),
                "4"
        );

        assertEquals(
                root.getRightChild().getLeftChild().getLeftChild().getLabel(),
                node.getRightChild().getLeftChild().getLeftChild().getLabel()
        );
        assertEquals(
                root.getRightChild().getLeftChild().getLeftChild().getLabel(),
                "5"
        );

        assertEquals(
                root.getRightChild().getLeftChild().getRightChild().getLabel(),
                node.getRightChild().getLeftChild().getRightChild().getLabel()
        );
        assertEquals(
                root.getRightChild().getLeftChild().getRightChild().getLabel(),
                "6"
        );
    }

}
