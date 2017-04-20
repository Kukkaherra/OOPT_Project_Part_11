/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;

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
       return this.patternName;
    }
    
    @Override
    public PatternHelper getChild(int i) {
        return null;
    }

    @Override
    public String toString() {
        return "Pattern " + getData();
    }

    @Override
    public void add(PatternHelper node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
