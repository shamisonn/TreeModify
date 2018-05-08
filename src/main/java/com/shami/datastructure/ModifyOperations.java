package com.shami.datastructure;

import java.util.Arrays;

public class ModifyOperations {

    private int[][] operations;
    private int opSize;

    public ModifyOperations(int nni) {
        this.operations = new int[10][nni];
        this.opSize = 0;
    }

    public void addOperation(int[] op) {
        Arrays.sort(op);
        this.operations[opSize] = op;
        this.opSize++;
    }

    public boolean isContain(int[] op) {
        Arrays.sort(op);
        for (int i = 0; i < this.opSize; i++) {
            boolean contain = true;
            for (int j = 0; j < this.operations[i].length; j++) {
                if(op[j] != this.operations[i][j]) {
                    contain = false;
                    break;
                }
            }
            if (contain) {
                return true;
            }
        }
        return false;
    }

}
