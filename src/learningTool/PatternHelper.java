package learningTool;

import java.util.ArrayList;

public interface PatternHelper {
    
    public void add(PatternHelper node);
    public String getData();
    public PatternHelper getChild(int i);
	public ArrayList<PatternHelper> getChildren();
	public void print();
}
