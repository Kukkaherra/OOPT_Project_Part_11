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
    
    public PatternNode(String PatternName) {
        this.patternName = patternName;
    }

    @Override
    public String getPattern() {
       return patternName;
    }

    @Override
    public void add(Pattern pattern) {

    }

    @Override
    public Pattern getChild(int i) {
        return null;
    }

    @Override
    public void print() {
        System.out.println("Pattern: " + getPattern());
    }
    
}
