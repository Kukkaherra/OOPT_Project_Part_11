/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;

/**
 *
 * @author MyMac
 */
public class Compound extends Pattern {
	
	private String description;
    
    public Compound() {
		this.description = readFile("src/learningTool/description.txt");
    }
    
	@Override
    public String getDescription() {
       return description;
    }
}
