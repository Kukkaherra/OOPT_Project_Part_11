package learningTool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import javafx.scene.image.Image;

public class Pattern {
	
    private String description;
    private String patternName;
    private ArrayList<DataTuple> sourceFiles = new ArrayList<>();
    private Image uml;
    
    public Pattern(String patternName) {
        this.patternName = patternName;
    }

    public String getDescription() {
       return description;
    }

    public String toString() {
        return patternName;
    }

    public ArrayList<DataTuple> getSourceFiles() {
        return sourceFiles;
    }
    
    public Image getUML() {
        return uml;
    }
    
    public void setUML(String path) {
        File file = new File(path);
        uml = new Image(file.toURI().toString());
        
    }
    
    
    public ArrayList<DataTuple> addSourcefile(String name, String path) throws IOException {
        this.sourceFiles.add(new DataTuple(PatternBuilder.readFile(path), name));  
        return sourceFiles;
    }
    
    /*public void addSourcefile(String name, String path) {
        this.sourceFiles.add(new DataTuple(readFile(path), name));
        // Description
        this.description = readFile("src/learningTool/description.txt");
        
        // UML
        File file = new File("src/learningTool/patterns/compound/uml.png");
        uml = new Image(file.toURI().toString());
    }*/
}
