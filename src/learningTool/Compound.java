package learningTool;

import java.io.File;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Compound extends Pattern {
	
	private String description;
    private static Compound instance = null;
    private ArrayList<DataTuple> sourceFiles = new ArrayList<>();
    private Image uml;
    
    public static Compound getInstance() {
        if (instance == null) {
            instance = new Compound();
        }
        return instance;
    }

    private Compound() {
        // Description
        this.description = readFile("src/learningTool/description.txt");
        
        // Sourcefiles
        this.sourceFiles.add(new DataTuple(readFile("src/learningTool/patterns/compound/Mainclass.txt"), "Main"));
        this.sourceFiles.add(new DataTuple(readFile("src/learningTool/patterns/compound/Compound_MVC_Controller.txt"), "Controller"));
        this.sourceFiles.add(new DataTuple(readFile("src/learningTool/patterns/compound/Compound_MVC_Model.txt"), "Model"));
        this.sourceFiles.add(new DataTuple(readFile("src/learningTool/patterns/compound/Compound_MVC_View.txt"), "View"));
        
        // UML
        File file = new File("src/learningTool/patterns/compound/uml.png");
        uml = new Image(file.toURI().toString());
    }

    @Override
    public String getDescription() {
       return description;
    }

    @Override
    public String toString() {
        return "Compound";
    }

    @Override
    public ArrayList<DataTuple> getSourceFiles() {
        return sourceFiles;
    }
    
    @Override
    public Image getUML() {
        return uml;
    }
}
