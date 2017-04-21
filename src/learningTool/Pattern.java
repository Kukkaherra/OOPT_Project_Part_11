package learningTool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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
