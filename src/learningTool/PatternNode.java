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
    
    public PatternNode(String PatternName) {
        this.patternName = patternName;
    }

    public String getPattern() {
       return patternName;
    }
    
    @Override
    public PatternHelper getChild(int i) {
        return null;
    }

    public String toSting() {
        return "Pattern " + getPattern();
    }

    @Override
    public void add(PatternHelper node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
