/**
 * @version 1.0
 * @author Alex Fahrer, HF-ICT FR21, PE-F
 */

package com.example.zeiterfassung_atl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class Kunde {

    /*
     * Attribute
     */
    private String name;
    private ArrayList<Problem> probleme = new ArrayList<>();

    /**
     * Erstellt einen neuen Kunden
     * @param name Name des Kunden
     */
    public Kunde(String name) {
        this.name = name;
    }

    /**
     * Erstellt ein neues Problem mit entsprechenden Parametern
     * @param bezeichnung Bezeichnung des Problems
     * @param time Zeit die für das Problem gestoppt wurde
     */
    public void onStop(String bezeichnung, String time) {
        Problem problem = new Problem();
        problem.setPid();
        problem.setBezeichnung(bezeichnung);
        problem.setTime(time);
        addProblem(problem);
        showInPrint();
    }

    /**
     * Gibt Angaben zum Kunden und dessen Problemen in der Konsole aus.
     * Dient rein als Testfunktion.
     */
    public void showInPrint() {
        System.out.println("");
        System.out.println("KUNDE: " + getName());
        System.out.println("ANZAHL PROBLEME: " + getProbleme().size());
        System.out.println("==============");
        for (Problem p:probleme
        ) {
            System.out.println("PROBLEM ID: " + p.getPid());
            System.out.println("PROBLEM BEZEICHNUNG: " + p.getBezeichnung());
            System.out.println("PROBLEM ZEIT: " + p.getTime());
            System.out.println("--------------");
        }
    }

    /**
     * Fügt ein Problem der Problemliste hinzu
     * @param problem Problem welches der Problemliste hinzugefügt wird
     */
    public void addProblem(Problem problem) {
        probleme.add(problem);
    }

    /**
     * Gibt eine Liste der Probleme zurück
     * @return FXCollections.observableArrayList(probleme)
     */
    public ObservableList<Problem> getProbleme() {
        return FXCollections.observableArrayList(probleme);
    }

    /**
     * Gibt den Namen des Kunden zurück
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Überschreibt die toString() Methode damit in der Choicebox der Name statt der Referenz angezeigt wird
     * @return getName()
     */
    @Override
    public String toString() {
        return getName();
    }
}
