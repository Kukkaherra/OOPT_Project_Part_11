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
                PatternHelper ph2 = new PatternNode("Compound");
                PatternHelper ph3 = new PatternNode("Adapter");
                PatternHelper comp = new PatternComposite("What pattern should I use");
                
                comp.add(ph1);
                comp.add(ph2);
                comp.add(ph3);
                
                PatternComposite pc = new PatternComposite("Suggest a pattern for me");
                pc.add(comp);
                System.out.println(pc);
                System.out.println(pc.getChild(0));
                System.out.println(pc.getChild(0).getChild(2));
		
        launch(args);
    }
    
}
