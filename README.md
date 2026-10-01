# GreenRide – Stationsübersicht

Stand der Stationsübersicht nach dem Mini-Projekt. Paket `org.alo.greenride`.

## Nachricht von Y. Kaya, Teamleitung Backend

> **Betreff:** Kasse Warschauer Straße abgestürzt
>
> Hallo zusammen,
>
> gestern Nachmittag ist an der Warschauer Straße mitten in einer Rückgabe die Kasse abgestürzt. Die Kollegin hatte sich bei der Kennung vertippt: **GR-041** statt **GR-014**. Danach ging nichts mehr, und die Kundin hinter ihr musste warten, bis neu gestartet war.
>
> Ich habe den Ablauf in `KassenApp` nachgestellt. Bevor jemand etwas repariert, möchte ich zwei Dinge geklärt haben:
>
> 1. Wessen Fehler ist das: der Methode `findeFahrrad` oder der Stelle, die sie aufruft?
> 2. Wie sorgen wir dafür, dass so etwas nicht wieder passieren kann – auch nicht, wenn später jemand Neues an diesem Code arbeitet?
>
> Viele Grüße
> Y. Kaya

## Starten

- `KassenApp` – die nachgestellte Rückgabe an der Kasse
- `GreenRideApp` – die Stationsübersicht aus dem Mini-Projekt
- `beispiel.PlaylistApp` – Beispiel zu `Optional` (Merkkarte, Seite 2)

## Klassen

| Klasse | Aufgabe |
|---|---|
| `Station` | Verleihstation, kennt ihre Fahrräder |
| `Fahrrad` | ein Rad, kennt seine Station und seine Wartungen |
| `Wartung` | eine Wartung an einem Rad (entsteht nur über `Fahrrad`) |
| `GreenRideApp` | Stationsübersicht |
| `KassenApp` | Rückgabe an der Kasse |
| `beispiel.Playlist`, `beispiel.Song`, `beispiel.PlaylistApp` | Beispiel: Suche mit `Optional` und mit leerer Liste |
