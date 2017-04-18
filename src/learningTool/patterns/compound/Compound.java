/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool.patterns.compound;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import learningTool.Pattern;

/**
 *
 * @author MyMac
 */
public class Compound extends Pattern {
    
    private String getFileContent(String path) throws FileNotFoundException, IOException{
        BufferedWriter bw;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            bw = new BufferedWriter(new FileWriter("output.txt"));
            String line;
        while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        }
        bw.close();
        return path;
    }
    
    private String getMethod(String method){return method;}
    
    private String getDescription(String description){return description;}
    
    private String getUML(String uml){return uml;}
    
    private ArrayList getSourceFiles(ArrayList sourceFiles){return sourceFiles;}
    
    
    
}
