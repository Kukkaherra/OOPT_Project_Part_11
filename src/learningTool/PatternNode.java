/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;

import java.util.ArrayList;

/**
 *
 * @author Oskari
 */
public class PatternNode implements PatternHelper {
    
    private String patternName;
    
    public PatternNode(String patternName) {
        this.patternName = patternName;
    }

    @Override
    public String getData() {
       return patternName;
    }
    
    @Override
    public PatternHelper getChild(int i) {
        return null;
    }

	public ArrayList<PatternHelper> getChildren() {
		return null;
	}

    @Override
    public String toString() {
        return patternName;
    }

    @Override
    public void add(PatternHelper node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
	@Override
	public void print() {
		System.out.println(this);
	}
    
}
