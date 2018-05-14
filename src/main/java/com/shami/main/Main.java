package com.shami.main;

import com.shami.datastructure.TreeNode;
import com.shami.io.TreeReader;
import com.shami.io.TreeWriter;
import com.shami.modify.TreeModifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String centerTreeFilename = args[0];
        int nni = 0;
        try {
            nni = new Integer(args[1]);
        } catch (Exception e) {
            System.err.println("nni を適切に設定してください");
            e.printStackTrace();
        }
        TreeReader tr = new TreeReader();
        TreeWriter tw = new TreeWriter();
        // center trees list
        List<TreeNode> trees = tr.readCenterTreesFromFile(centerTreeFilename);
        int leafNum = trees.get(0).getLeafNumber();
        int instNumber = 1;
        for (TreeNode tree: trees) {
            TreeModifier tm = new TreeModifier(tree, nni);
            List<String> modifiedTrees = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                modifiedTrees.add(tm.modify());
            }
            String filename = "./leaf" + leafNum + "nni"+ nni +"no" + instNumber + ".trees";
            instNumber += 1;
            tw.writeFile(modifiedTrees, filename);
        }

        // TreeNode root = tr.makeTree("((1,2),(3,((4,5),(((6,7),8),(9,10)))));");


    }

}
