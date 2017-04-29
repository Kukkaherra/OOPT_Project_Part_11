package learningTool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Pattern {
	
    private String description;
    private String patternName;
    private ArrayList<DataTuple> sourceFiles = new ArrayList<>();
    private String umlPath;
    
    public Pattern(String patternName) {
        this.patternName = patternName;
		this.description = PatternBuilder.readFile("src/learningTool/patterns/" + patternName + "/description.txt");
		umlPath = "src/learningTool/patterns/" + patternName + "/uml.png";
    }
	
	public ArrayList<DataTuple> addSourcefile(String name, String path) throws IOException {
		// Also remove file extension from name with substring
        this.sourceFiles.add(new DataTuple(PatternBuilder.readFile(path), name.substring(0, name.lastIndexOf('.'))));  
        return sourceFiles;
    }
	
	public ArrayList<DataTuple> getSourceFiles() {
        return sourceFiles;
    }
    
    public String getUMLPath() {
        return umlPath;
    }

    public String getDescription() {
       return description;
    }
	
    public String toString() {
        return patternName;
    }
}
