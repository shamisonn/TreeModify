package com.shami.io;

import com.shami.datastructure.TreeNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeReader {

    public List<TreeNode> readCenterTreesFromFile(String path) {
        Scanner fsc = null;
        try {
            fsc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<TreeNode> trees = new ArrayList<>();
        assert fsc != null;
        while (fsc.hasNext()) {
            String treeInput = fsc.next();
            trees.add(this.makeTree(treeInput));
        }

        return trees;
    }

    // "((1,2),(3,((4,5),(((6,7),8),(9,10)))));"
    // "(3,(1,2));"
    protected TreeNode makeTree(String input) {
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
                    leaf.beLeaf();
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
