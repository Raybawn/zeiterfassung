/**
 * @version 1.0
 * @author Alex Fahrer, HF-ICT FR21, PE-F
 */

package com.example.zeiterfassung_atl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Lädt das GUI Fenster mit der ersten Scene
     * @param Stage GUI Komponente
     */
    @Override
    public void start(Stage Stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ZeiterfassungView.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 400, 300);
            Stage.setScene(scene);
            Stage.setTitle("Zeiterfassung");
            Stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Startet die Applikation.
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}