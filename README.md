### Modul Praktikum Objektorientierte Programmierung ###

## Aufgabe 1.1: Abseits ##
<br>

### Beschreibung

Mehrere Spieler würfeln hintereinander. Ziel des Spiels ist es, als Augensumme eine festgelegte Zahl (Abseits) nicht zu überschreiten.
<br>

### Aufgabenstellung

Schreiben Sie ein Programm für das Abseitsspiel. Zunächst wird die Abseitszahl zwischen 30 und 50 zufällig festgelegt. Das Spiel selbst besteht aus mehreren Runden. Die Spieler würfeln hintereinander.

Die gewürfelten Augenzahlen werden addiert. Wer die Abseitszahl überschreitet, scheidet aus. Die anderen Spieler beginnen eine neue Runde. Die bisher erreichten Augensummen aller Spieler werden gelöscht. Der nächste Spieler ist dran. Wer übrig geblieben ist, gewinnt das Spiel.
<br><br>

### Testprogramm

Eingabe

Anzahl der Spieler; Namen der Mitspieler; Würfeln (RETURN: Simulation eines Wurfs, stoppt den Würfel).

Ausgabe

Spielregeln; Abseitszahl; aktueller Spieler; gewürfelte Augenzahl; erreichte Augensumme; Spiel-auswertung.

Abbruch

Das Programm bricht ab, falls die Nutzer kein neues Spiel wünschen.

<br>

### Hinweise zum Programm

Speichern Sie die Spielerdaten (aktuelle Augensumme, ist ausgeschieden) in einem Feld ab und regeln Sie über den Index, welcher Spieler gerade dran ist (zum Beispiel dran = (dran + 1) % spieler Anzahl).

Geben Sie nach Abschluss eines jeden Spiels den Gewinner an.
