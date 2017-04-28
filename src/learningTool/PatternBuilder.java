package learningTool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class PatternBuilder {
	
	ArrayList<Pattern> patterns = new ArrayList<>();

	public PatternBuilder() {
		try {
            File[] directories = new File("src/learningTool/patterns").listFiles(File::isDirectory);
            for (File directory : directories) {
				Pattern pattern = new Pattern(directory.getName());
				Stream<Path> paths = Files.walk(Paths.get("src/learningTool/patterns/" + pattern.toString() + "/"));{
				paths.forEach(filePath -> {
				if (Files.isRegularFile(filePath)) {
					try {
						pattern.addSourcefile(readFile(filePath.getName(4).toString()), filePath.toString());
						pattern.setUML(filePath.toString());
						patterns.add(pattern);
					} catch (IOException ex) {
						Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				});
				}   
			}
        } catch (IOException eio) {
            System.err.print(eio);
        } 
	}

	public static String readFile(String path) {
		String content = null;
		try {
			content = new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			System.err.print(e);
		}
		return content; 
	}
	
	public ArrayList<Pattern> getPatterns() {
		return patterns;
	}

}
