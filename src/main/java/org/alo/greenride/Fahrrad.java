package org.alo.greenride;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Fahrrad von GreenRide.
 *
 *   Fahrrad  0..* -------- 1     Station   (Assoziation)
 *   Fahrrad  1    <>------ 0..*  Wartung   (Komposition)
 */
public class Fahrrad {

    private String kennung;
    private String modell;
    private double tagespreis;

    private Station station;                              // Multiplizitaet 1    -> ein Attribut
    private List<Wartung> wartungen = new ArrayList<>();  // Multiplizitaet 0..* -> eine Liste

    public Fahrrad(String kennung, String modell, double tagespreis) {
        this.kennung = kennung;
        this.modell = modell;
        this.tagespreis = tagespreis;
    }

    /** Legt eine neue Wartung an. Nur so entstehen Wartungen. */
    public void wartungHinzufuegen(String datum, String beschreibung) {
        wartungen.add(new Wartung(datum, beschreibung));
    }

    public void wartungshistorieAusgeben() {
        System.out.println("Wartungen von " + kennung + ":");
        if (wartungen.size() == 0) {
            System.out.println("  (noch keine)");
        }
        for (Wartung w : wartungen) {
            System.out.println("  " + w.getDatum() + " - " + w.getBeschreibung());
        }
    }

    public String getKennung()    { return kennung; }
    public String getModell()     { return modell; }
    public double getTagespreis() { return tagespreis; }

    public Station getStation()   { return station; }

    /** Wird von Station.fahrradAufnehmen aufgerufen. */
    void setStation(Station station) {                    // kein public!
        this.station = station;
    }
}
