package edu.westga.comp4420.javafx_sample.view.codebehind;

import java.util.List;

import edu.westga.comp4420.javafx_sample.model.Craft;
import edu.westga.comp4420.javafx_sample.model.Pattern;
import edu.westga.comp4420.javafx_sample.model.Progression;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * CodeBehind To Handle Processing for the UpdatePatternWindow
 *
 * @version Spring 2025
 * @author Genesis Ross
 */
public class UpdatePatternWindow {

    @FXML
    private TextField authorTB;

    @FXML
    private RadioButton completeRadioBTN;

    @FXML
    private RadioButton crochetRadioBTN;

    @FXML
    private AnchorPane guiPane;

    @FXML
    private RadioButton inCompleteRadioBTN;

    @FXML
    private RadioButton inProgressRadioBTN;

    @FXML
    private RadioButton knitRadioBTN;

    @FXML
    private TextField patternNameTB;

    @FXML
    private TextField websiteTB;

    @FXML
    private ComboBox<Integer> yarnWeightCB;

    private List<Pattern> patterns;

    private void closeWindow() {
		this.guiPane.getScene().getWindow().hide();
	}

    public void setPatternDetails(Pattern pattern) {
        this.authorTB.setText(pattern.getAuthor());
        this.patternNameTB.setText(pattern.getPatternName());
        this.websiteTB.setText(pattern.getWebsite());
        this.yarnWeightCB.getSelectionModel().select(pattern.getYarnWeight() - 1);
        this.crochetRadioBTN.setSelected(pattern.getCraft().equals(Craft.Crochet));
        this.knitRadioBTN.setSelected(pattern.getCraft().equals(Craft.Knit));
        this.completeRadioBTN.setSelected(pattern.getProgression().equals(Progression.Complete));
        this.inCompleteRadioBTN.setSelected(pattern.getProgression().equals(Progression.Incomplete));
        this.inProgressRadioBTN.setSelected(pattern.getProgression().equals(Progression.InProgress));
    }

    private Craft craft() {
        Craft selectedCraft = Craft.Unknown;
        if (this.knitRadioBTN.isSelected()) {
            selectedCraft = Craft.Knit;
        } else if (this.crochetRadioBTN.isSelected()) {
            selectedCraft = Craft.Crochet;
        }
        return selectedCraft;
    }
    
    private Progression progression() {
        Progression selectedProgression = Progression.Unknown;
        if (this.inCompleteRadioBTN.isSelected()) {
            selectedProgression = Progression.Incomplete;
        } else if (this.inProgressRadioBTN.isSelected()) {
            selectedProgression = Progression.InProgress;
        } else if (this.completeRadioBTN.isSelected()) {
            selectedProgression = Progression.Complete;
        }
        return selectedProgression;
    }

    @FXML
    void onCloseBTN(ActionEvent event) {
        this.closeWindow();
    }

    @FXML
    void onCompleteRB(ActionEvent event) {

    }

    @FXML
    void onCrochetRB(ActionEvent event) {

    }

    @FXML
    void onInCompleteRB(ActionEvent event) {

    }

    @FXML
    void onInProgressRB(ActionEvent event) {

    }

    @FXML
    void onKnitRB(ActionEvent event) {

    }

    @FXML
    void onUpdateBTN(ActionEvent event) {
        try {
            String patternName = this.patternNameTB.getText();
            String authorName = this.authorTB.getText();
            String websiteName = this.websiteTB.getText();
            Craft craft = this.craft();
            Progression progression = this.progression();
            int yarnWeight = this.yarnWeightCB.getSelectionModel().getSelectedItem();
            Pattern pattern = new Pattern(patternName, authorName, websiteName, craft, progression, yarnWeight);
            this.patterns.add(pattern);
            this.closeWindow();

        } catch (IllegalArgumentException error) {
            Alert errorBox = new Alert(AlertType.ERROR);
			errorBox.setContentText(error.getMessage());
			errorBox.showAndWait();
        }
    }

    public void setItemList(List<Pattern> patterns) {
        this.patterns = patterns;
    }

    
    @FXML
    void initialize() {
        this.yarnWeightCB.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6));

        assert this.authorTB != null : "fx:id=\"authorTB\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";
        assert this.guiPane != null : "fx:id=\"guiPane\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";
        assert this.patternNameTB != null : "fx:id=\"patternNameTB\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";
        assert this.websiteTB != null : "fx:id=\"websiteTB\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";
        assert this.yarnWeightCB != null : "fx:id=\"yarnWeightCB\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";
        assert this.completeRadioBTN != null : "fx:id=\"completeRadioBTN\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";
        assert this.inCompleteRadioBTN != null : "fx:id=\"inCompleteRadioBTN\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";
        assert this.inProgressRadioBTN != null : "fx:id=\"inProgressRadioBTN\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";
        assert this.crochetRadioBTN != null : "fx:id=\"crochetRadioBTN\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";
        assert this.knitRadioBTN != null : "fx:id=\"knitRadioBTN\" was not injected: check your FXML file 'AddPatternWindow.fxml'.";

    }
}
