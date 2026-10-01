package org.alo.greenride;

/**
 * Eine einzelne Wartung an einem Fahrrad.
 *
 * Wartungen werden NICHT von aussen erzeugt, sondern nur ueber
 * fahrrad.wartungHinzufuegen(...). Deshalb ist der Konstruktor
 * nicht public.
 */
public class Wartung {

    private String datum;
    private String beschreibung;

    Wartung(String datum, String beschreibung) {     // kein public!
        this.datum = datum;
        this.beschreibung = beschreibung;
    }

    public String getDatum() {
        return datum;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}
