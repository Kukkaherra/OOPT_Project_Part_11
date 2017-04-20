package learningTool;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eetu
 */
public class Mainclass extends Application {
       
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		
               
                PatternHelper ph1 = new PatternNode("Composite");
                PatternHelper comp1 = new PatternComposite("Composite 1");
                PatternHelper comp2 = new PatternComposite("Composite 2");
                PatternHelper comp21 = new PatternComposite("Composite 21");
                
                comp2.add(comp21);
                comp21.add(ph1);
                
              
                PatternComposite root = new PatternComposite("This is root component");
                root.add(comp1);
                root.add(comp2);
                System.out.println(root.getChild(1).getChild(0).getChild(0));

		
        launch(args);
    }
    
}
