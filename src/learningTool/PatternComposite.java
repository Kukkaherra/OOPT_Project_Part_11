package learningTool;

import java.util.ArrayList;

public class PatternComposite implements PatternHelper{
    
    private String question;
    ArrayList<PatternHelper> childNodes = new ArrayList<>();
    
    public PatternComposite(String question) {
        this.question = question;
    } 
    
    public String getData() {
        return question;
    }

	public ArrayList<PatternHelper> getChildren() {
		return childNodes;
	}
	
    public void add(PatternHelper node) {
       childNodes.add(node);
    }

    public PatternHelper getChild(int i) {
        return childNodes.get(i);
    }

    @Override
    public String toString() {
        return question;
    }

	public void print() {
		System.out.println("Composite: " + this);
		for (PatternHelper ph : childNodes) {
			ph.print();
		}
	}
    
}
