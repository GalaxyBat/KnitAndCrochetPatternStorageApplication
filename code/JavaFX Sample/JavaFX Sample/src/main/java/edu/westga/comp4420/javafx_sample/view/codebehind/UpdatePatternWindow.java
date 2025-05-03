package edu.westga.comp4420.javafx_sample.view.codebehind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
    void onCloseBTN(ActionEvent event) {

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

    }

    
    @FXML
    void initialize() {
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
