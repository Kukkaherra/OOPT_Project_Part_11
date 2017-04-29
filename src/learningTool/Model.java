package learningTool;

import java.util.ArrayList;

// Holds all the data and current state of the application
public class Model {
	private PatternHelper root;
	private PatternHelper selectedHelper;

	private Pattern selectedPattern;

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

		HelperBuilder hb = new HelperBuilder();
		root = hb.parse(hb.getRoot());
	}
	
	public PatternHelper getRoot() {
		return root;
	}

	public PatternHelper getSelectedHelper(){
		return selectedHelper;
	}

	public void setSelectedHelper(PatternHelper ph) {
		selectedHelper = ph;
	}

	public Pattern getSelectedPattern() {
		return selectedPattern;
	}

	public void setSelectedPattern(Pattern p) {
		selectedPattern = p;
	}

	public ArrayList getPatternList() {
		return patterns;
	}
}
