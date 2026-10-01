package org.alo.greenride;

/**
 * Nachgestellt: Rueckgaben an der Kasse der Station Warschauer Strasse
 * am Nachmittag des 01.10. Die Mitarbeiterin tippt die Kennung vom
 * Rahmen ab. Bei der zweiten Rueckgabe hat sie sich vertippt.
 */
public class KassenApp {

    public static void main(String[] args) {
        Station warschauer = new Station("Warschauer Strasse", "Warschauer Str. 12");
        warschauer.fahrradAufnehmen(new Fahrrad("GR-001", "City 3", 12.00));
        warschauer.fahrradAufnehmen(new Fahrrad("GR-002", "City 3", 12.00));
        warschauer.fahrradAufnehmen(new Fahrrad("GR-014", "Lastenrad", 24.00));

        rueckgabeBuchen(warschauer, "GR-014");
        rueckgabeBuchen(warschauer, "GR-041");   // vertippt: 41 statt 14
        rueckgabeBuchen(warschauer, "GR-002");
    }

    static void rueckgabeBuchen(Station station, String kennung) {
        Fahrrad rad = station.findeFahrrad(kennung);
        System.out.println("Rueckgabe gebucht: " + rad.getKennung()
                + " (" + rad.getModell() + ")");
    }
}
