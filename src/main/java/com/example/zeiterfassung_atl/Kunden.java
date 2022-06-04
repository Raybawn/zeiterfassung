/**
 * @version 1.0
 * @author Alex Fahrer, HF-ICT FR21, PE-F
 */

package com.example.zeiterfassung_atl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kunden {

    /*
     * Attribute
     */
    ObservableList<Kunde> kundenListe = FXCollections.observableArrayList();

    /**
     * Fix definierte Kunden.
     */
    public Kunden() {
        Kunde kunde1 = new Kunde("Johnson");
        Kunde kunde2 = new Kunde("Apple");
        Kunde kunde3 = new Kunde("Synology");
        Kunde kunde4 = new Kunde("BMW");
        Kunde kunde5 = new Kunde("Respawn Entertainment");

        kundenListe.add(kunde1);
        kundenListe.add(kunde2);
        kundenListe.add(kunde3);
        kundenListe.add(kunde4);
        kundenListe.add(kunde5);
    }

    /**
     * Gibt eine Liste der Kunden zurück
     * @return kundenListe
     */
    public ObservableList<Kunde> getKundenListe() {
        return kundenListe;
    }
}
