package learningTool;

import java.io.IOException;
import java.util.ArrayList;

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
