package org.alo.greenride;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Eine Verleihstation von GreenRide.
 *
 *   Station  1 -------- 0..*  Fahrrad
 */
public class Station {

    private String name;
    private String adresse;

    private List<Fahrrad> fahrraeder = new ArrayList<>();

    public Station(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    /**
     * @param modell    Modelle von Farrädern
     * @return          gibt die Liste der Fahrräder zurück
     * */
    public List<Fahrrad> findeFahrraederNachModell(String modell) {
        List<Fahrrad> finde = new ArrayList<>();
        for (Fahrrad f : fahrraeder) {
            if (f.getModell().equals(modell)) {
                finde.add(f);
            }
        }
        return finde;
    }

    /**
     * Neues Fahrrad wird aufgenommen
     *
     * @param fahrrad nimmt neues Fahrrad auf
     *
     * @return  Wenn was zurückkommt --> neues Fahrrad
     *          Wenn Fahrrad vorhanden, dann:
     *
     * @throws IllegalArgumentException Wenn Fahrrad bereits vorhanden
     */
    public void fahrradAufnehmen(Fahrrad fahrrad) {
        fahrraeder.add(fahrrad);
        fahrrad.setStation(this);
    }

    public void fahrraederAusgeben() {
        System.out.println("Fahrraeder an Station " + name + ":");
        for (Fahrrad f : fahrraeder) {
            System.out.println("  " + f.getKennung() + " (" + f.getModell() + ")");
        }
    }

    /**
     * @param kennung ein fahrrad kennung
     * @return das Fahrrad oder ein null
     *
     * @throws IllegalArgumentException wenn kennung NULL oder empty
     * */
    public Optional<Fahrrad> findeFahrrad(String kennung) {
        for (Fahrrad f : fahrraeder) {
            if (f.getKennung().equals(kennung)) {
                return Optional.of(f);
            }
        }
        return Optional.empty();
    }

    public String getName()    { return name; }
    public String getAdresse() { return adresse; }

    public List<Fahrrad> getFahrraeder() { return fahrraeder; }
}
