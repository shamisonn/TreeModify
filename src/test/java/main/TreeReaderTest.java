package main;

import com.shami.datastructure.TreeNode;
import com.shami.main.TreeReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeReaderTest {
    @Test
    void makeTreeTest1() {
        TreeReader tr = new TreeReader();
        TreeNode node = tr.makeTree("(3,(1,2));");
        assertEquals("3", node.getLeftChild().getLabel());
        assertEquals("1", node.getRightChild().getLeftChild().getLabel());
        assertEquals("2", node.getRightChild().getRightChild().getLabel());
    }

}
