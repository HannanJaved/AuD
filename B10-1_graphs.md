Darstellung von Graphen
---

**TODO:** Insert your answer for task 1, 3 and 4!


1/

-Ein Graph G besteht aus einer Menge an Knoten V und einer Menge aus Kanten E.
Die Knoten werden mit Kanten verbunden, wobei eine Kante immer genau zwei Knoten miteinander verknüpft.
"Ein Grapf ist abstrakte Struktur, die eine Menge von Objekten zusammen mit den zwischen diesen Objekten bestehenden Verbindungen repräsentiert".(Wiki).

-Gerichtete und ungerichtete Graphen
Allgemein gilt es zwischen gerichteten und ungerichteten Graphen zu differenzieren.
Der Unterschied liegt in der Art der Kanten, die die Knoten verbinden.
Ist eine Verbindung zweier Knoten ein Pfeil, so ist der Graph gerichtet und die Kante darf nur in einer Richtung genutzt werden.
Wie du siehst, ist es dir im gerichteten Graphen beispielsweise nicht erlaubt,
vom Knoten B zum Knoten A zu gehen, da die Kante nur in die entgegengesetzte Richtung zeigt.

Wird eine Kante im Graphen hingegen als einfache Verbindung zwischen zwei Knoten dargestellt,
ist der Graph ungerichtet und es muss nicht auf die Richtung geachtet werden.


( Vorlesung ) :
-Ungerichtete Graphen (undirected graph)
Ein ungerichteter Graph ist ein geordnetes Paar G = (V,E) mit
einer Menge von Knoten V und
einer Menge von Kanten E ⊆ {i,j} | i,j ∈ V ∧i != j

-Gerichtete Graphen (directed graph, kurz: digraph)
Ein gerichteter Graph ist ein geordnetes Paar G = (V,E) mit
einer Menge von Knoten V und
einer Menge von Kanten E ⊆ (i,j) | i,j ∈ V



2/

G = ( V,E ) mit :
V = {1, 2, 3, 4, 5}
E = {(1, 2), (1, 3), (1, 4), (1, 5), (2, 4), (2, 5), (3, 4), (4, 5)}

Darstellung :

   2-- -------1
    \       //
   | \     // |
   |  \ 5 //  |
   |   \ //   |
   |    //    |
   |   //     |
   |  //      |
   | //       |
   | /        |
   4----------3


(1, 2) ja
(1, 3) ja
(1, 4) ja
(1, 5) ja
(2, 4) ja
(2, 5) ja
(3, 4) ja
(4, 5) ja

3/


a/
die Kantenliste : E = {(1, 2), (1, 3), (1, 4), (1, 5), (2, 4), (2, 5), (3, 4), (4, 5)}
In java :
int[] edgelist = { 5,8,1,2,1,3,1,4,1,5,2,4,2,5,3,4,4,5 }
-Erste zwei Einträge bezeichnen die Anzahl Knoten (5) und Kanten (8)
-Je zwei aufeinanderfolgende Einträge bezeichnen eine Kante

b/
die Knotenliste :V = {1, 2, 3, 4, 5}
In java :
int[] nodelist = { 5,8, 4,2,3,4,5, 3,1,4,5 2,1,4, 4,1,2,3,5, 3,1,2,4 };
-Nächste Zahl speichert Anzahl ausgehende Kanten
-Es folgt Liste der Nachbarknoten

c/
die Adjazenzmatrix :
     1 2 3 4 5

    |  1 1 1 1|   2,3,4,5
    |1     1 1|   1,4,5
A = |1     1  |   1,4
    |1 1 1   1|   1,2,3,5
    |1 1   1  |   1,2,4


Zahlen kodieren Gewichte: γ(i,j) = Aij
Gewicht 0 ist unzulässig, denn Aij = 0 ⇔ keine Kante

In java :
int[][] adjanzmatrix = {{0,1,1,1,1},{1,0,0,1,1},{1,0,0,1,0},{1,1,1,0,1},{1,1,0,1,0}};



d/
die Adjazenzliste : ( int[] nodelist = { 5,8, 4,2,3,4,5, 3,1,4,5 2,1,4, 4,1,2,3,5, 3,1,2,4 }
-Speichere Nachbarschaften ähnlich wie in Knotenlisten, aber ermögliche dynamische Änderungen
-Speichere Zeilen der Adjazenzmatrix ohne Nulleinträge


1 ---> 2,3,4,5
|
2 ---> 1,4,5
|
3 ---> 1,4
|
4 ---> 1,2,3,5
|
5 ---> 1,2,4

In java :

List[] liste = new ArrayList[Anzahl der Knoten];
Z.B
List<Integer>[] Adjazenzliste = new ArrayList<Integer>[5](); // 5 Anzahl der knoten


4/

a/


Wir können die Kanten in zwei Arrays edge_a[] und edge_b[] speichern, wobei (edge_a[i], edge_b[i]) eine Kante zwischen zwei Knoten darstellt. Die Arrays haben die Länge M, wobei M die Anzahl der Kanten

public class EdgelistToAdjmatrix {

    public static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int k=0; k<matrix[0].length; k++){
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5; // 5 knoten
        int a,b ;

        int[] edge_a = {0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4}; // knoten 0, 1 ,2 ,3, 4
        int[] edge_b = {1, 3, 4, 0, 2, 3, 4, 1, 3, 0, 1, 2, 4, 0, 1, 3}; // Destination

        int[][] adjMatrix = new int[n][n]; // adjacency matrix - initialized

        // traversieren a und b

        for(int i=0; i<edge_a.length; i++){
            a = edge_a[i]; b = edge_b[i];

            adjMatrix[a][b] = 1;
        }
        System.out.println("Adjazenzmatrix");
        printMatrix(adjMatrix);
    }
}

b/

import java.util.ArrayList;

public class EdgelistToAdjalist {

    public static void printAdjList(ArrayList<ArrayList<Integer>> adjList){
        int n = adjList.size();
        for(int i=0; i<n; i++){
            System.out.println(i + "-->" + adjList.get(i));
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[] edge_a = {0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4};
        int[] edge_b = {1, 3, 4, 0, 2, 3, 4, 1, 3, 0, 1, 2, 4, 0, 1, 3};

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) adjList.add(new ArrayList<Integer>());

        for(int i=0; i<edge_a.length; i++){
            int a = edge_a[i]; int b = edge_b[i];
            adjList.get(a).add(b);
        }
        System.out.println("Adjazenzliste");
        printAdjList(adjList);

    }
}

o(n+m) wobei n= Anzahl an Knoten und m= Anzahl an Elemente ( liste )


Wael Jallali / Hannan Mahadik