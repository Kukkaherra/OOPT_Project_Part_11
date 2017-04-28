package learningTool;

import java.util.ArrayList;

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
    
    private Model() {
		PatternBuilder pb = new PatternBuilder();
		patterns = pb.getPatterns();
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