/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author MyMac
 */
public abstract class Pattern {
    
    public String path;
    
    
    /*private String getFileContent(String path) throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
        while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        }
        bw.close();
        return path;
    }*/
    
    static String readFile(String path) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded); 
    }
    
    private String getMethod(String method){return method;}
    
    public String getDescription() throws IOException {
        String des = readFile(path);
        return des;
    }
    
    private String getUML(String uml){return uml;}
    private ArrayList getSourceFiles(ArrayList sourceFiles){return sourceFiles;}
}
