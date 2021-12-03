Lösungsidee
---

**TODO**

Betrachten Sie n Personen, die an einem Tisch sitzen.
Die k-te Person wird ausgeschieden.
Dann beginnt die Zählung bei der k+1ten Person, und die kte Person scheidet wieder aus.
Um dies mit Hilfe von Queues zu realisieren, entfernen wir jede Person aus der Queue und fügen sie am Ende der Queue hinzu, bis wir die k-te Person erreicht haben.
Dann entfernen wir die k-te Person aus der Queue und fügen diese Person in eine neue AusgabeQueue ein, um zu zeigen, wer ausgeschieden ist.
Wir wiederholen dies, bis die ursprüngliche Queue leer ist.


Beispiel: Lösung für 13 Personen und 7 Silben im Abzählreim
---

**TODO**

Remaining : 1 2 3 4 5 6 7 8 9 10 11 12 13
remove7 = 7

Remaining : 8 9 10 11 12 13 1 2 3 4 5 6
remove7 = 1

Remaining : 2 3 4 5 6 8 9 10 11 12 13
remove7 = 9

Remaining : 10 11 12 13 2 3 4 5 6 8
remove7 = 4

Remaining : 5 6 8 10 11 12 13 2 3
remove7 = 13

Remaining : 2 3 5 6 8 10 11 12
remove7 = 11

Remaining : 12 2 3 5 6 8 10
remove7 = 10

Remaining : 12 2 3 5 6 8
Josephus und seine 5 Freunden sollen am 2.,3.,5.,6.,8. und 12. Platz sitzen.