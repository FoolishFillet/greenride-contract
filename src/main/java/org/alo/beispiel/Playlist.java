package org.alo.beispiel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Playlist {

    private List<Song> songs = new ArrayList<>();

    public void songHinzufuegen(Song song) {
        songs.add(song);
    }

    /**
     * Sucht einen Song anhand seines Titels.
     *
     * @param titel der genaue Titel, z. B. "Intro"
     * @return der gefundene Song; ein leeres Optional, wenn kein Song
     *         diesen Titel hat
     */
    public Optional<Song> findeSong(String titel) {
        for (Song s : songs) {
            if (s.getTitel().equals(titel)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    /**
     * Sucht alle Songs eines Interpreten.
     *
     * @param interpret der Name, z. B. "The xx"
     * @return eine neue Liste mit allen passenden Songs;
     *         eine leere Liste, wenn keiner passt - niemals null
     */
    public List<Song> findeSongsVon(String interpret) {
        List<Song> treffer = new ArrayList<>();
        for (Song s : songs) {
            if (s.getInterpret().equals(interpret)) {
                treffer.add(s);
            }
        }
        return treffer;
    }
}
