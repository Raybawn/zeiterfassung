/**
 * @version 1.0
 * @author Alex Fahrer, HF-ICT FR21, PE-F
 */

package com.example.zeiterfassung_atl;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    /*
     * Attribute
     */
    private Kunde aktiverKunde;
    private boolean idle = true;
    Stopwatch stopwatch = new Stopwatch();

    @FXML
    private Pane p1;

    @FXML
    private ChoiceBox kundenWahl;

    @FXML
    private Button stopwatchButton;

    @FXML
    private Label timeLabel;

    @FXML
    private TextArea txtProblem;

    /**
     * Lädt die Scene für "Übersicht" zur Stage
     */
    @FXML
    protected void goToUebersicht() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UebersichtView.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage s = (Stage) p1.getScene().getWindow();
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.setTitle("Übersicht");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Regelt das Verhalten beim Drücken des "START/STOP" Buttons
     * Prüft ob ein Kunde ausgewählt ist und ob eine Bezeichnung für das Problem besteht
     * Startet und stoppt die Zeit mittels Stoppuhr-Funktion
     * Gibt die gestartete und gestoppte Zeit als Text im GUI aus
     */
    @FXML
    public void onPress() {
        if (kundenWahl.getSelectionModel().isEmpty()) {
            timeLabel.setText("Kein Kunde!");
        } else if (txtProblem.getText().equals("")) {
            timeLabel.setText("Kein Text!");
        } else {
            if (idle) {
                stopwatch.onStart();
                stopwatchButton.setText("STOP");
                timeLabel.setText(stopwatch.getTime());
                idle = false;
            } else {
                aktiverKunde = (Kunde) kundenWahl.getSelectionModel().getSelectedItem();
                stopwatch.onStop();
                aktiverKunde.onStop(txtProblem.getText(), stopwatch.getTotalTime());
                stopwatchButton.setText("START");
                timeLabel.setText(stopwatch.getTime());
                idle = true;
            }
        }
    }

    /**
     * Initialisiert die Werte für die Ansicht
     * Lädt die Kundenliste in das Dropdownmenü und wählt das erste Element als Standard aus
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kundenWahl.setItems(Singleton.getInstance().getAllKunden());
        kundenWahl.getSelectionModel().selectFirst();
    }
}