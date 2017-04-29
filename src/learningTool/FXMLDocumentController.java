package learningTool;

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

public class FXMLDocumentController implements Initializable {
	private Model model;
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
	private ListView<Pattern> patternList;
	@FXML
	private Text sourceCode;
	@FXML
	private Text breadCrumbs;
	@FXML
	private ListView<PatternHelper> questionList;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		model = Model.getInstance();
		// The listviews in the UI use toString by default as what each item is displayed as (if it is object and not a string),
		// so remember to override your toStrings(), and make your own ones ;)
		ObservableList<Pattern> patterns = FXCollections.observableArrayList(model.getPatternList());
		patternList.setItems(patterns);
		ResetHelperAction();
	}

	@FXML
	private void selectPattern() throws IOException {
		clearTabs();
		model.setSelectedPattern(patternList.getSelectionModel().getSelectedItem());
		patternUMLButton.setDisable(false); // Tool starts with no selected pattern; after which, it is impossible to deselect
		patternName.setText(model.getSelectedPattern().toString()); // Can simply use: patternName.setText(selectedPattern.toString(), once everything is said and done)
		patternDescription.setText(model.getSelectedPattern().getDescription());
		
		ArrayList<DataTuple> dtlist = model.getSelectedPattern().getSourceFiles();
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
		Stage stage = new Stage();
		stage.setScene(new Scene(new Pane(new ImageView(new Image(new File(model.getSelectedPattern().getUMLPath()).toURI().toString())))));
		stage.show();
	}

	@FXML
	private void selectRequirement(MouseEvent event) {
		Integer index = questionList.getSelectionModel().getSelectedIndex();
		if (index != -1 && model.getSelectedHelper() != null) {
			model.setSelectedHelper(model.getSelectedHelper().getChild(index));
			updateHelper();
			if (model.getSelectedHelper().getChildren().size() == 1) { // we've reached a leaf
				model.setSelectedHelper(null); // Just to prevent user from going past the leaf node 
			}
		}
	}

	private void updateHelper() {
		if (model.getSelectedHelper() != null) { // Just to prevent user from going past the leaf node 
			String crumb = model.getSelectedHelper().getData() + "  >  ";
			breadCrumbs.setText(breadCrumbs.getText() + crumb);
			ObservableList<PatternHelper> questions = FXCollections.observableArrayList(model.getSelectedHelper().getChildren());
			questionList.setItems(questions);
		}
	}

	@FXML
	private void ResetHelperAction() {
		model.setSelectedHelper(model.getRoot());
		updateHelper();
		breadCrumbs.setText("");
	}
}
