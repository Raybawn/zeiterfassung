/**
 * @version 1.0
 * @author Alex Fahrer, HF-ICT FR21, PE-F
 */

package com.example.zeiterfassung_atl;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Stopwatch {

    /*
     * Attribute
     */
    public boolean on = false;
    private LocalTime stopTime;
    private LocalTime startTime;
    private String totalTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * Regelt was beim drücken des "START" Buttons passiert
     */
    public void onStart() {
        start();
    }

    /**
     * Regelt was beim drücken des "STOP" Buttons passiert
     */
    public void onStop() {
        stop();
        totalTime();
    }

    /**
     * Gibt an das die Uhr gestartet wurde und erfasst die start Zeit
     */
    public void start() {
        on = true;
        startTime = LocalTime.now();
    }

    /**
     * Gibt an das die Uhr gestoppt wurde und erfasst die stop Zeit
     */
    public void stop() {
        on = false;
        stopTime = LocalTime.now();
    }

    /**
     * Berrechnet die Zeit zwischen start und stop der Uhr
     * Rundet die Minuten im Viertelstundentakt auf
     * Speichert die total Zeit als String in totalTime
     */
    public void totalTime() {
        Duration duration = Duration.between(startTime, stopTime);
        int totalHours = duration.toHoursPart();
        int totalMinutes = duration.toMinutesPart();

        if (totalMinutes >= 0 && totalMinutes <= 14) {
            totalMinutes = 15;
        } else if (totalMinutes >= 15 && totalMinutes <= 29) {
            totalMinutes = 30;
        } else if (totalMinutes >= 30 && totalMinutes <= 44) {
            totalMinutes = 45;
        } else if (totalMinutes >= 45 && totalMinutes <= 59) {
            totalMinutes = 00;
            totalHours += 1;
        }

        totalTime = String.format("%2dh %02dm", totalHours, totalMinutes);
    }

    /**
     * Gibt die total Zeit als String zurück
     * @return totalTime
     */
    public String getTotalTime() {
        return totalTime;
    }

    /**
     * Prüft ob die Uhr läuft oder nicht, gibt entsprechend die Startzeit oder die total Zeit zurück
     * @return "Start: " + startTime.format(formatter) oder "Zeit: " + totalTime
     */
    public String getTime() {
        if (on) {
            return "Start: " + startTime.format(formatter);
        } else {
            return "Zeit: " + totalTime;
        }
    }
}


