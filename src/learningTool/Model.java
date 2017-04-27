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
    
    public PatternComposite getRoot() {
        return root;
    }
    
    public ArrayList getPatternList() {
        return patterns;
    }
    
}
