package com.shami.main;

import com.shami.datastructure.TreeNode;
import com.shami.io.TreeReader;

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
        TreeNode root = tr.makeTree("((1,2),(3,((4,5),(((6,7),8),(9,10)))));");


    }

}
