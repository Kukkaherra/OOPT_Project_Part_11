/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author MyMac
 */
public class Template {
     private final String description;
     private ArrayList<String> sourceFiles = new ArrayList<>();

    public Template() {
        this.description = FileReader.readFile("src/learningTool/description.txt");
        this.sourceFiles.add(FileReader.readFile("src/learningTool/Mainclass.txt"));
    }
    
    public String getDescription() {
       return description;
    }

    public Image getUML() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList getSourceFiles() {
        return sourceFiles;
    }
    
    public String toString() {
        return "Template";
    }
    
}
