/**
 * @version 1.0
 * @author Alex Fahrer, HF-ICT FR21, PE-F
 */

package com.example.zeiterfassung_atl;

import javafx.collections.ObservableList;

public class Singleton {

    /*
     * Attribute
     */
    private static Singleton instance;
    Kunden kunden = new Kunden();

    /**
     * @see Singleton
     */
    private Singleton() {};

    /**
     * @see Singleton
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    /**
     * Gibt die Kundenliste zurück
     * @return kunden.getKundenListe()
     */
    public ObservableList<Kunde> getAllKunden() {
        return kunden.getKundenListe();
    }
}
