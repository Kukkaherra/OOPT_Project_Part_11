package learningTool;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        // The listviews in the UI use toString by default as what each item is displayed as (if it is object and not a string),
        // so remember to override your toStrings(), and make your own ones ;)
        
        // TODO: Change this to ObservableList<Pattern> = model.getInstance().getPatternList();
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
        
        // TODO: Change this to whatever the fuck the tree structure will be, possibly:
        // ObservableList<PatternHelper> = model.getInstance().getRoot();
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
        Pattern com = Compound.getInstance();
        
        selectedPattern = patternList.getSelectionModel().getSelectedItem();
        patternUMLButton.setDisable(false); // Tool starts with no selected pattern; after which, it is impossible to deselect
        patternName.setText(selectedPattern); // Can simply use: patternName.setText(selectedPattern.toString(), once everything is said and done)
        patternDescription.setText(com.getDescription());
        
        ArrayList<DataTuple> dtlist = com.getSourceFiles();
        for (DataTuple dt : dtlist) {
            addTab(dt.getFileName(), dt.getCode());
        }
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

    @FXML
    private void UMLButtonAction(ActionEvent event) throws IOException {
        
        // TODO: Change this to 'selectedPattern'
        Pattern com = Compound.getInstance();
        Image img = com.getUML();
        
        Stage stage = new Stage();
        stage.setScene(new Scene(new Pane(new ImageView(img))));
        stage.show();
    }
    
}
