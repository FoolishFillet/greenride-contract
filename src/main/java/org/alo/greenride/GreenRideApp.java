package org.alo.greenride;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Startet die Stationsuebersicht und fuehrt die Anforderungen
 * aus dem Lastenheft der Reihe nach vor.
 */
public class GreenRideApp {

    public static void main(String[] args) {

        // --- A1: Ausgangslage anlegen ---------------------------------
        Station warschauer = new Station("Warschauer Strasse", "Warschauer Str. 12");
        Station kottbusser = new Station("Kottbusser Tor", "Adalbertstr. 4");

        Fahrrad f1 = new Fahrrad("GR-001", "City 3", 12.00);
        Fahrrad f2 = new Fahrrad("GR-002", "City 3", 12.00);
        Fahrrad f3 = new Fahrrad("GR-014", "Lastenrad", 24.00);
        Fahrrad f4 = new Fahrrad("GR-020", "City 3", 12.00);
        Fahrrad f5 = new Fahrrad("GR-021", "Kinderrad", 8.00);

        warschauer.fahrradAufnehmen(f1);
        warschauer.fahrradAufnehmen(f2);
        warschauer.fahrradAufnehmen(f3);

        kottbusser.fahrradAufnehmen(f4);
        kottbusser.fahrradAufnehmen(f5);

        f3.wartungHinzufuegen("14.09.2026", "Bremse nachgestellt");
        f3.wartungHinzufuegen("28.09.2026", "Kette geoelt");

        ;
        System.out.println("Warschauer\nCity3: " + warschauer.findeFahrraederNachModell("City 3").size() + "\nE-Bike: " + warschauer.findeFahrraederNachModell("E-Bike").size() + "\n");


        // --- A2: Wo steht ein bestimmtes Fahrrad? ---------------------
        System.out.println("GR-014 steht an: " + f3.getStation().getName());
        System.out.println("GR-020 steht an: " + f4.getStation().getName());
        System.out.println();

        // --- A3: Alle Fahrraeder einer Station ------------------------
        warschauer.fahrraederAusgeben();
        System.out.println();
        kottbusser.fahrraederAusgeben();
        System.out.println();

        // --- A4: Wartungshistorie -------------------------------------
        f3.wartungshistorieAusgeben();
        System.out.println();

        // --- A5: Fahrrad ueber die Kennung finden ---------------------
        Optional<Fahrrad> gefunden = warschauer.findeFahrrad("GR-002");
        if (gefunden.isPresent()) {
        System.out.println("Gesucht GR-002, gefunden: " + gefunden.get().getModell());
        }else{
            return;
        }

        Optional<Fahrrad> fehlt = warschauer.findeFahrrad("GR-999");
        if (fehlt.isPresent()) {
            System.out.println("Gesucht GR-999, gefunden: " + fehlt);
        }
        System.out.println();

        // --- K2: ueber alle Stationen ---------------------------------
        List<Station> stationen = new ArrayList<>();
        stationen.add(warschauer);
        stationen.add(kottbusser);

        Optional<Fahrrad> ueberall = sucheUeberall(stationen, "GR-020");
        if (ueberall.isPresent()) {
            Fahrrad fahrrad = ueberall.get();
            System.out.println("sucheUeberall(\"" + fahrrad.getKennung() + "\") -> " + fahrrad.getModell() + " @ " + ueberall.get().getStation().getName());
        }
    }

    /**
     * Sucht Fahrrad und seine Station
     *
     * @param stationen findet Station
     * @param kennung findet Fahrrad
     *
     * @return gibt Fahrrad mit Station und Modell zurück
     *
     * @throws IllegalArgumentException Falsche Daten machen falsche Ausgaben
     */
    static Optional<Fahrrad> sucheUeberall(List<Station> stationen, String kennung) {
        for (Station s : stationen) {
            Optional<Fahrrad> f = s.findeFahrrad(kennung);
            if (f.isPresent()) {
                return f;
            }
        }
        return Optional.empty();
    }
}
