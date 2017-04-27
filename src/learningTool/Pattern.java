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
    
    public String readFile(String path) {
        String content = null;
        try {
                content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
                System.err.print(e);
        }
        return content; 
    }

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
    
    public void setUML(File file, String path) {
        file = new File(path);
        uml = new Image(file.toURI().toString());
        
    }
    
    public void directorySearch() throws IOException {
        File[] directories = new File("src/learningTool/patterns").listFiles(File::isDirectory);
        for (File directory : directories) {
            Pattern pattern = new Pattern(directory.getName());
        }
        Stream<Path> paths = Files.walk(Paths.get("src/learningTool/patterns/"));{
        paths.forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                //Print Directory
               // System.out.println(filePath.getName(3));
                //Print file content
              //  System.out.println(readFile(filePath.toString()));
            }
        });
        }
    }
    public ArrayList<DataTuple> addSourcefile(String name, String path) throws IOException {
        this.sourceFiles.add(new DataTuple(readFile(path), name));  
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
