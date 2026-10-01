package org.alo.beispiel;

public class Song {
    private String titel;
    private String interpret;
    private int dauerSekunden;

    public Song(String titel, String interpret, int dauerSekunden) {
        this.titel = titel;
        this.interpret = interpret;
        this.dauerSekunden = dauerSekunden;
    }

    public String getTitel()      { return titel; }
    public String getInterpret()  { return interpret; }
    public int getDauerSekunden() { return dauerSekunden; }
}
