package org.alo.beispiel;

import java.util.List;
import java.util.Optional;

public class PlaylistApp {

    public static void main(String[] args) {
        Playlist lernen = new Playlist();
        lernen.songHinzufuegen(new Song("Weightless", "Marconi Union", 480));
        lernen.songHinzufuegen(new Song("Intro", "The xx", 128));
        lernen.songHinzufuegen(new Song("Angels", "The xx", 171));

        // Ein Ergebnis, das fehlen kann: Optional
        Optional<Song> treffer = lernen.findeSong("Intro");
        if (treffer.isPresent()) {
            Song song = treffer.get();
            System.out.println("Gefunden: " + song.getInterpret());
        } else {
            System.out.println("Diesen Song gibt es nicht.");
        }

        Optional<Song> keiner = lernen.findeSong("Gibt es nicht");
        if (keiner.isPresent()) {
            System.out.println("Gefunden: " + keiner.get().getInterpret());
        } else {
            System.out.println("Diesen Song gibt es nicht.");
        }

        // Viele Ergebnisse, vielleicht keins: Liste
        List<Song> vonTheXx = lernen.findeSongsVon("The xx");
        System.out.println("Songs von The xx: " + vonTheXx.size());
        List<Song> vonAdele = lernen.findeSongsVon("Adele");
        System.out.println("Songs von Adele: " + vonAdele.size());
    }
}
