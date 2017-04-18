/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningTool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author MyMac
 */
public abstract class Pattern {
 
    
	public Pattern() {
	}
    
    public String readFile(String path) {
		String content = null;
		try {
			content = new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			System.err.print(e);
		}
		return content; 
    }
    
    public String getMethod(){
		throw new UnsupportedOperationException();
	}
	
	public String getDescription(){
		throw new UnsupportedOperationException();
	}
    
    public String getUML(){
		throw new UnsupportedOperationException();
	}
	
    public ArrayList getSourceFiles() {
		throw new UnsupportedOperationException();
	}
}
