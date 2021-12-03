Red-Black-Tree
---
A)
Aus der Vorlesung:
Ein Rot-Schwarz-Baum (red-black tree) ist ein binärer Suchbaum,
in dem jedem Konten ein Farbattribut zugeordnet ist, so dass gilt
1 - Ein Knoten ist entweder rot oder schwarz.
2 - Die Wurzel ist schwarz. (Man kann die Wurzel immer umfärben.)
3 - Alle Blätter sind schwarz. (Annahme: Blätter sind Null-Knoten/dummies, d.h. nur interne Knoten halten Schlüssel.)
4 - Beide Kinder eines roten Knotens sind schwarz.
5 - Jeder Pfad von einem gegebenen Knoten zu einem
erreichbaren Blatt enthält dieselbe Anzahl schwarzer Knoten.

B)
[6, 7, 3, 4, 2, 1]

1)             6(Rot)              6 (Schwarz)
              /\          ->       /\

2)             6 (Schwarz)
               /\
                 7 (Rot)
                 /\

3)              6 (Schwarz)
                /\
         (Rot) 3  7 (Rot)
              /\  /\

4)              6 (Schwarz)
                /\
         (Rot) 3  7 (Rot)
              /\  /\
               4(Rot)        //ROT-ROT Verstoss

->               6 (Schwarz)
                /\
     (Schwarz) 3  7 (Schwarz)
              /\  /\
               4(Rot)
               /\

5)               6 (Schwarz)
                /\
     (Schwarz) 3  7 (Schwarz)
              /\  /\
       (Rot) 2  4(Rot)
            /\  /\

6)               6 (Schwarz)
                /\
     (Schwarz) 3  7 (Schwarz)
              /\  /\
       (Rot) 2  4(Rot)
            /\  /\
     (Rot) 1                //ROT-ROT Verstoss
          /\

7)               6 (Schwarz)
                /\
         (Rot) 3  7 (Schwarz)
              /\  /\
    (Schwarz)2  4(Schwarz)
            /\  /\
     (Rot) 1
          /\


C)
[6, 7, 3, 4, 2, 1]
AVL Tree

        6   ->   6    ->    6    ->   6 ->
        /\       /\         /\        /\
                   7       3  7      3  7
                                    /\  /\
                                      4
  ->   6   ->     6     ->    3
       /\         /\         /\
      3  7       3  7       2  6
     /\  /\     /\  /\     /\  /\
    2  4       2  4       1   4  7
              /\
             1

D)
    x      ->      x(Schwarz)
   /\             /\

   x|y     ->      y(Schwarz)
   /|\             /\
             (Rot)x
                 /\
   x|y|z   ->       y(Schwarz)
   /| |\           /\
             (Rot)x  z(Rot)
                 /\  /\

- Rot-Schwarz baum ist eine Umsetzung von 2-3-4 Baum
z.B. x,y,z mit drei 4 Unterkanten werden zu 2 Rotenknoten und ein Schwarze-Wurzel