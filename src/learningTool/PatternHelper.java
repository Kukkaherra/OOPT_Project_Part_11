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
    
    public void add(PatternHelper node);
    public String getData();
    public PatternHelper getChild(int i);
    public String toString();
}
