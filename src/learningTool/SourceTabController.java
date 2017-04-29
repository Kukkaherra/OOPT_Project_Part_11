package learningTool;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class SourceTabController implements Initializable {
	@FXML
	private Text sourceCode;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
			// TODO
	}
	
	public void setSource(String source) {
		sourceCode.setText(source);
	}
}
