/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;

import java.util.ArrayList;

/**
 *
 * @author MyMac
 */
public abstract class Pattern {
    
    
    private String getFileContent(String path){return path;}
    private String getMethod(String method){return method;}
    private String getDescription(String description){return description;}
    private String getUML(String uml){return uml;}
    private ArrayList getSourceFiles(ArrayList sourceFiles){return sourceFiles;}
}
