package io;

import com.shami.datastructure.TreeNode;

public class TreeReader {

    // "((1,2),(3,((4,5),(((6,7),8),(9,10)))));"
    // "(3,(1,2));"
    public TreeNode makeTree(String input) {
        input = input.substring(1, input.length() - 2);
        TreeNode root = new TreeNode(null);

        TreeNode currentNode = root;
        boolean setLeafLeft = true;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            switch (c) {
                case '(':
                    // make new node
                    TreeNode node = new TreeNode(currentNode);
                    if (currentNode.isLeftEmpty()) {
                        currentNode.setLeftChild(node);
                    } else if (currentNode.isRightEmpty()) {
                        currentNode.setRightChild(node);
                    }
                    currentNode = node;
                    setLeafLeft = true;
                    break;
                case ',':
                    // move right node
                    setLeafLeft = false;
                    break;
                case ')':
                    // switch current node to parent
                    currentNode = currentNode.getParent();
                    break;
                default:
                    // get label string from "someStr" to ',' or ')'
                    TreeNode leaf = new TreeNode(currentNode);
                    leaf.beLeaf(true);
                    i = setLabel2delimiter(chars, i, leaf);
                    // and set leaf for right or left
                    if (setLeafLeft) {
                        currentNode.setLeftChild(leaf);
                        setLeafLeft = false;
                    } else {
                        currentNode.setRightChild(leaf);
                        setLeafLeft = true;
                    }

                    break;

            }
        }

        return root;
    }

    private int setLabel2delimiter(char[] chars, int i, TreeNode node) {
        StringBuilder sb = new StringBuilder();
        for (;i < chars.length;i++) {
            if (chars[i] != ',' && chars[i] != '(' && chars[i] != ')') {
                sb.append(chars[i]);
            } else {
                break;
            }
        }
        node.setLabel(sb.toString());
        i--;
        return i;
    }
}
