package learningTool;

import java.util.ArrayList;

public class PatternComposite implements PatternHelper{
    
    private String question;
    ArrayList<PatternHelper> childNodes = new ArrayList<>();
    
    public PatternComposite(String question) {
        this.question = question;
    } 
    
	@Override
    public String getData() {
        return question;
    }

	@Override
	public ArrayList<PatternHelper> getChildren() {
		return childNodes;
	}
	
	@Override
    public void add(PatternHelper node) {
       childNodes.add(node);
    }

	@Override
    public PatternHelper getChild(int i) {
        return childNodes.get(i);
    }

    @Override
    public String toString() {
        return question;
    }

	@Override
	public void print() {
		System.out.println("Composite: " + this);
		childNodes.forEach((ph) -> {
			ph.print();
		});
	}
    
}
