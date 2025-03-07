package edu.westga.comp4420.javafx_sample.view.codebehind;

// import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;
// import javafx.stage.Modality;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Alert.AlertType;
// import javafx.scene.control.ListView;

// import java.io.IOException;

// import main.java.edu.westga.comp4420.javafx_sample.model.Pattern;
// import edu.westga.comp4420.javafx_sample.Main;


/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	Comp 4420
 * @version Spring 2024
 */
public class MainWindow {   

    @FXML
    private AnchorPane guiPane;

    @FXML
    private ListView<Pattern> patternListView;

    @FXML
    void deletePatternBTN(ActionEvent event) {

    }

    @FXML
    void newPatternBTN(ActionEvent event) {
        // try {
		// 	FXMLLoader loader = new FXMLLoader();
		// 	loader.setLocation(Main.class.getResource(Main.ADD_PATTERN_WINDOW_RESOURCE));
		// 	loader.load();
		// 	Parent parent = loader.getRoot();
		// 	Scene scene = new Scene(parent);
		// 	Stage addPatternStage = new Stage();
		// 	addPatternStage.setTitle(Main.WINDOW_TITLE);
		// 	addPatternStage.setScene(scene);
		// 	addPatternStage.initModality(Modality.APPLICATION_MODAL);

		// 	AddItemWindow controller = (AddPatternWindow) loader.getController();
		// 	controller.setItemList(this.patternListView.getItems());

		// 	addItemStage.showAndWait();
		// } catch (IOException error) {
		// 	Alert errorBox = new Alert(AlertType.ERROR);
		// 	errorBox.setContentText("Unable to open add window");
		// 	errorBox.showAndWait();
		// }

    }

    @FXML
	void initialize() {
		assert this.patternListView != null : "fx:id=\"patternListView\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
	}
}
