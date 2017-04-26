package learningTool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Mainclass extends Application {
       
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // I'm a HTML + CSS guy, java responsive design goes over my head
        stage.setResizable(false);
    }

    public static void main(String[] args) {

       // Model model = Model.getInstance();
       Pattern comp = Compound.getInstance();
       System.out.println(comp.getSourceFiles().get(0));
        
       launch(args);
    }
    
}
