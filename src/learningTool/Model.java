package learningTool;

import java.util.ArrayList;

public class Model {
    
    private PatternComposite root;
    ArrayList<Pattern> patterns = new ArrayList<>();
    
    public void patternList() {
        patterns.add(Compound.getInstance());
    }
    
    public Model() {
        
        patternList();
        PatternHelper ph1 = new PatternNode("Composite");
        PatternHelper comp1 = new PatternComposite("Composite 1");
        PatternHelper comp2 = new PatternComposite("Composite 2");
        PatternHelper comp21 = new PatternComposite("Composite 21");
        
        root = new PatternComposite("This is root.");
        comp2.add(comp21);
        comp21.add(ph1);

        System.out.println(root.getChild(1).getChild(0).getChild(0));    
    }
    
    public PatternComposite getRoot() {
        return root;
    }
    
    public ArrayList getPatternList() {
        return patterns;
    }
    
}
