/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;
import java.io.IOException;
import learningTool.Pattern;

/**
 *
 * @author MyMac
 */
public class Compound extends Pattern {
    
    private String description;

    public Compound() throws IOException {
    }
    
    @Override
    public String getDescription() throws IOException {
        String des = readFile(path);
        return des;
    }
}
