/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oskari
 */
public class PatternComposite implements PatternHelper{
    
    private String patternName;
    List patterns = new ArrayList();
    
    public PatternComposite(String patternName) {
        this.patternName = patternName;
    } 
 
    @Override
    public String getPattern() {
       return patternName;
    }

    @Override
    public void add(Pattern pattern) {
       patterns.add(pattern);
    }

    @Override
    public Pattern getChild(int i) {
        return (Pattern) patterns.get(i);
    }

    @Override
    public void print() {
        System.out.println("Pattern: " + getPattern());
        

    }
    
}
