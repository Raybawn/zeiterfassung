/**
 * @version 1.0
 * @author Alex Fahrer, HF-ICT FR21, PE-F
 */

package com.example.zeiterfassung_atl;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UebersichtController implements Initializable {

    /*
     * Attribute
     */
    private Kunde aktiverKunde;
    ObservableList<Kunde> kundenMitProblemen = FXCollections.observableArrayList();

    @FXML
    private Pane p2;

    @FXML
    private ChoiceBox kundenWahl;

    @FXML
    private TableView<Problem> tblView;

    @FXML
    private TableColumn<Problem, String> tblColBezeichnung = new TableColumn<>("Bezeichnung");

    @FXML
    private TableColumn<Problem, String> tblColZeit = new TableColumn<>("Zeit");

    @FXML
    private TableColumn<Problem, Boolean> tblColErfasst = new TableColumn<>("Erfasst");

    /**
     * Lädt die Scene für "Zeiterfassung" zur Stage
     */
    @FXML
    protected void goToZeiterfassung() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ZeiterfassungView.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage s = (Stage) p2.getScene().getWindow();
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.setTitle("Zeiterfassung");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Lädt die Probleme des ausgewählten Kunden in die Tabellenübersicht
     */
    @FXML
    public void listProbleme() {
        tblView.setItems(aktiverKunde.getProbleme());

        tblColBezeichnung.setCellValueFactory(new PropertyValueFactory<>("bezeichnung"));
        tblColZeit.setCellValueFactory(new PropertyValueFactory<>("time"));
        tblColErfasst.setCellValueFactory(new PropertyValueFactory<>("erfasst"));
        tblColErfasst.setCellFactory(CheckBoxTableCell.forTableColumn(tblColErfasst));

        tblView.getColumns().setAll(tblColBezeichnung, tblColZeit, tblColErfasst);
    }

    /**
     * Initialisiert die Werte für die Ansicht
     * Speichert Kunden mit Problemen in einer separaten kundenMitProblemen Liste
     * Lädt die kundenMitProblemen Liste in das Dropdownmenü
     * Prüft auf Änderungen der Dropdownauswahl und lädt entsprechend die Probleme des ausgewählten Kunden
     * Wählt das erste verfügbare Element (Kunde) im Dropdown als Standard
     * @see Initializable
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Zeige nur Kunden mit Problemen im Dropdown der Übersicht an.
        for (Kunde k:Singleton.getInstance().getAllKunden()
             ) {
                if (k.getProbleme().size() != 0) {
                    kundenMitProblemen.add(k);
                }
        };

        kundenWahl.setItems(kundenMitProblemen);
        kundenWahl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Kunde>() {
            @Override
            public void changed(ObservableValue observableValue, Kunde alt, Kunde neu) {
                aktiverKunde = neu;
                listProbleme();
            }
        });

        kundenWahl.getSelectionModel().selectFirst();
    }
}