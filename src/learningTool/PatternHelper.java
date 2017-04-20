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
public interface PatternHelper {
    
    public String getPattern();
    public void add(Pattern pattern);
    public Pattern getChild(int i);
    public void print();
}
