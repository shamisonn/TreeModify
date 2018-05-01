package com.shami.main;

import com.shami.datastructure.TreeNode;

public class Main {
    public static void main(String[] args) {
        TreeReader tr = new TreeReader();

        TreeNode root = tr.makeTree("((1,2),(3,((4,5),(((6,7),8),(9,10)))));");
        
    }

}
