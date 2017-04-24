package learningTool;

import java.util.ArrayList;

public class Compound extends Pattern {
	
	private String description;
        private static Compound instance = null;
        private ArrayList<DataTuple> sourceFiles = new ArrayList<>();
        
        public static Compound getInstance() {
            if (instance == null) {
                instance = new Compound();
            }
            return instance;
        }
    
        private Compound() {
            this.description = readFile("src/learningTool/description.txt");
            DataTuple dt = new DataTuple(readFile("src/learningTool/patterns/compound/Mainclass.txt"), "Mainclass");
            this.sourceFiles.add(dt);
        /*    this.sourceFiles.add(readFile("src/learningTool/patterns/compound/Mainclass.txt"));
            this.sourceFiles.add(readFile("src/learningTool/patterns/compound/Compound_MVC_Controller.txt"));
            this.sourceFiles.add(readFile("src/learningTool/patterns/compound/Compound_MVC_Model.txt"));
            this.sourceFiles.add(readFile("src/learningTool/patterns/compound/Compound_MVC_View.txt"));*/
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
        public ArrayList getSourceFiles() {
            return sourceFiles;
            }
}
