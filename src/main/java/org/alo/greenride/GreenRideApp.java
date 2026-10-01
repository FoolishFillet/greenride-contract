package org.alo.greenride;

import java.util.ArrayList;
import java.util.List;

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
        Fahrrad gefunden = warschauer.findeFahrrad("GR-002");
        System.out.println("Gesucht GR-002, gefunden: " + gefunden.getModell());

        Fahrrad fehlt = warschauer.findeFahrrad("GR-999");
        System.out.println("Gesucht GR-999, gefunden: " + fehlt);
        System.out.println();

        // --- K2: ueber alle Stationen ---------------------------------
        List<Station> stationen = new ArrayList<>();
        stationen.add(warschauer);
        stationen.add(kottbusser);

        Fahrrad ueberall = sucheUeberall(stationen, "GR-020");
        System.out.println("sucheUeberall(\"GR-020\") -> "
                + ueberall.getModell() + " @ " + ueberall.getStation().getName());
    }

    /** Sucht ein Fahrrad an allen uebergebenen Stationen. */
    static Fahrrad sucheUeberall(List<Station> stationen, String kennung) {
        for (Station s : stationen) {
            Fahrrad f = s.findeFahrrad(kennung);
            if (f != null) {
                return f;
            }
        }
        return null;
    }
}
