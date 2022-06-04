/**
 * @version 1.0
 * @author Alex Fahrer, HF-ICT FR21, PE-F
 */

package com.example.zeiterfassung_atl;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Problem {

    /*
     * Attribute
     */
    private static int counter = 0;
    private int pid;
    private String b;
    private String t;
    private final BooleanProperty erfasst = new SimpleBooleanProperty(this, "erfasst", false);

    /**
     * Gibt die pid des Problems zurück
     * @return this.pid Problem ID
     */
    public int getPid() {
        return this.pid;
    }

    /**
     * Erhöht den Counter um 1 und übergibt den Wert an pid
     */
    public void setPid() {
        counter++;
        pid = counter;
    }

    /**
     * Gibt die Bezeichnung des Problems zurück
     * @return b Bezeichnung des Problems
     */
    public String getBezeichnung() {
        return b;
    }

    /**
     * Setzt die Bezeichnung des Problems
     * @param b Bezeichnung des Problems
     */
    public void setBezeichnung(String b) {
        this.b = b;
    }

    /**
     * Gibt die Zeit des Problems zurück
     * @return t Zeit des Problems
     */
    public String getTime() {
        return t;
    }

    /**
     * Setzt die Zeit des Problems
     * @param t Zeit des Problems
     */
    public void setTime(String t) {
        this.t = t;
    }

    /**
     * Gibt true/false zurück ob das Problem erfasst (abgehackt) wurde
     * @return erfasst
     */
    public BooleanProperty erfasstProperty() {
        return erfasst;
    }
}
