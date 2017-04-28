package learningTool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Model {
    
    private PatternComposite root;
    private static Model instance = null;
    ArrayList<Pattern> patterns = new ArrayList<>();
    
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }
    
    public String readFile(String path) {
        String content = null;
        try {
                content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
                System.err.print(e);
        }
        return content; 
    }
    
    public void patternList() {
        //patterns.add(Compound);
    }
    
    private Model() {
        
        patternList();
        PatternHelper ph1 = new PatternNode("Composite");
        PatternHelper comp1 = new PatternComposite("Composite 1");
        PatternHelper comp2 = new PatternComposite("Composite 2");
        PatternHelper comp3 = new PatternComposite("Composite 21");
        
        PatternComposite root = new PatternComposite("This is root.");
        comp1.add(ph1);
        root.add(comp1);
        root.add(comp2);
        root.add(comp3);

        System.out.println(root.getChild(0).getChild(0));    
    }
    
    public void directorySearch(){
        try {
            File[] directories = new File("src/learningTool/patterns").listFiles(File::isDirectory);
            for (File directory : directories) {
            Pattern pattern = new Pattern(directory.getName());
            Stream<Path> paths = Files.walk(Paths.get("src/learningTool/patterns/" + pattern.toString() + "/"));{
            paths.forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                try {
                    pattern.addSourcefile(readFile(filePath.getName(4).toString()), filePath.toString());
                    pattern.setUML(filePath.toString());
                    patterns.add(pattern);
                } catch (IOException ex) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            }   
        }
        } catch (IOException eio) {
            System.err.print(eio);
        }  
    }
    
    public PatternComposite getRoot() {
        return root;
    }
    
    public ArrayList getPatternList() {
        return patterns;
    }
    
}
            /*for (int i = 0; i <= directory.length(); i++) {
                //pattern.addSourcefile(pattern.toString(), path);
                patterns.add(pattern);
            }*/
        
       /* Stream<Path> paths = Files.walk(Paths.get("src/learningTool/patterns/"));{
        paths.forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                //Print Directory
               // System.out.println(filePath.getName(3));
                //Print file content
              //  System.out.println(readFile(filePath.toString()));
            }
        });
        }*/