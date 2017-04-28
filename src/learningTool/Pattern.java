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
		this.description = PatternBuilder.readFile("src/learningTool/" + patternName + "/description.txt");
		setUML("src/learningTool/" + patternName + "/uml.png");
    }
	
	public ArrayList<DataTuple> addSourcefile(String name, String path) throws IOException {
        this.sourceFiles.add(new DataTuple(PatternBuilder.readFile(path), name));  
        return sourceFiles;
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

    public String getDescription() {
       return description;
    }
	
    public String toString() {
        return patternName;
    }
}
