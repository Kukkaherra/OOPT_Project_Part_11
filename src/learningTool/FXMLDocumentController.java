package learningTool;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 *
 * @author Eetu
 */
public class FXMLDocumentController implements Initializable {
    
    //private Pattern selectedPattern;
    private String selectedPattern;
    
    private Label label;
    @FXML
    private AnchorPane menuSection;
    @FXML
    private AnchorPane patternSection;
    @FXML
    private TabPane patternCode;
    @FXML
    private Label patternName;
    @FXML
    private Button patternUMLButton;
    @FXML
    private Text patternDescription;
    @FXML
    private ListView<String> patternList;
    @FXML
    private Text sourceCode;
    @FXML
    private FlowPane breadCrumbs;
    @FXML
    private ListView<String> questionList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> items = FXCollections.observableArrayList (
            "Abstract Factory",
            "Adapter",
            "Command",
            "Composite",
            "Compound",
            "Decorator",
            "Facade",
            "Factory Method",
            "Iterator",
            "Observer",
            "Proxy",
            "Singleton",
            "State",
            "Strategy",
            "Template Method"
        );
        patternList.setItems(items);
        
        ObservableList<String> questions = FXCollections.observableArrayList (
            "I need to create objects...",
            "I need to compose objects into larger structures...",
            "I need to dictate behaviour between objects..."
        );
        questionList.setItems(questions);
        
        //breadCrumbs.getChildren().add(new Label("I need to create objects... >"));
    }    

    @FXML
    private void selectPattern() throws IOException {
        clearTabs();
        Pattern com = new Compound();
        // Mockuppia varten tässä, loppuversiossa lista ei oo stringejä, vaan näitä olioita.
        
        selectedPattern = patternList.getSelectionModel().getSelectedItem();
        patternUMLButton.setDisable(false); // Tool starts with no selected pattern after which, it is impossible to deselect
        patternName.setText(selectedPattern);
        patternDescription.setText(com.getDescription());
        
        // Tän lisäämisen voi sit lopullisessa tehä hienommin sillee että olio esim kerää omat tiedostonsa tai jotain,
        // ja tästä vois vaan tyylii for each:lla avaa tabin joka source filulle.
        addTab("Main", com.readFile("src/learningTool/patterns/compound/Mainclass.txt"));
        addTab("Model", com.readFile("src/learningTool/patterns/compound/Compound_MVC_Model.txt"));
        addTab("View", com.readFile("src/learningTool/patterns/compound/Compound_MVC_View.txt"));
        addTab("Controller", com.readFile("src/learningTool/patterns/compound/Compound_MVC_Controller.txt"));
        addTab("Output", "");
    }
    
    public void clearTabs() {
        patternCode.getTabs().clear();  // Clear all existing tabs
    }
    
    public void addTab(String title, String content) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SourceTab.fxml"));
        
        Tab tab = new Tab(title);
        tab.setContent(loader.load());
        
        SourceTabController controller = loader.<SourceTabController>getController();
        controller.setSource(content);
        
        patternCode.getTabs().add(tab);
        
    }
    
}
