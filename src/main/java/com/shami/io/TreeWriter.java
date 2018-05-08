package com.shami.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class TreeWriter {

    public void writeFile(List<String> treesString, String path) {
        try {
            Writer w = new FileWriter(path);
            for (String s : treesString) {
                w.write(s);
                w.write('\n');
            }
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
