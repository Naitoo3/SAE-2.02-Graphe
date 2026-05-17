package testSprint1;

import GrapheMethodes.GrapheListe;
import org.junit.jupiter.api.Test;

public class Test_GrapheListeAdjacence {

    /**
     * Premier test sur les graphes à Listes d'adjacences.
     */

    public void TestGrapheListeAdjacence() {
            GrapheListe monGraphe = new GrapheListe("Racine");

            System.out.println("--- Test Ajout des Sommets ---");
            monGraphe.addNode("A");
            monGraphe.addNode("B");
            monGraphe.addNode("C");
            monGraphe.addNode("D");
            monGraphe.nodes();

            System.out.println("\n--- Test Ajout des Arêtes (A->B, B->C, C->D, A->D) ---");
            monGraphe.addEdge("A", "B");
            monGraphe.addEdge("B", "C");
            monGraphe.addEdge("C", "D");
            monGraphe.addEdge("A", "D");

            System.out.println("\n--- Test de la méthode contains ---");
            System.out.println("Contient A ? " + monGraphe.contains("A"));
            System.out.println("Contient Z ? " + monGraphe.contains("Z"));

            System.out.println("\n--- Test de la méthode neighbors (Voisins) ---");
            // Doit afficher B et D
            monGraphe.neighbors("A");
            // Doit afficher C
            monGraphe.neighbors("B");
            // Doit afficher D
            monGraphe.neighbors("C");
            // Doit être vide
            monGraphe.neighbors("D");

            System.out.println("\n--- Test Erreur (Sommet inexistant) ---");
            monGraphe.neighbors("Z");
        }

    /**
     * Deuxième test sur le graphe à Liste, avec des cas particuliers. (Sommet Z qui n'existe pas).
     */
    @Test
    public void TestGrapheListe2() {
        GrapheListe Graphe2 = new GrapheListe("Racine");

        System.out.println("--- Test Ajout des Sommets ---");
        Graphe2.addNode("A");
        Graphe2.addNode("B");
        Graphe2.addNode("C");
        Graphe2.addNode("D");
        Graphe2.nodes();

        // Ajout d'arrêtes sur d'autres sommets + ceux qui n'existent pas

            Graphe2.addEdge("A", "B");
            Graphe2.addEdge("B", "C");
            Graphe2.addEdge("C", "D");
            Graphe2.addEdge("A", "D");
            try {
                Graphe2.addEdge("Z", "A");
                System.out.printf("Erreur ! - Le sommet Z n'existe pas dans le graphe.");
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            }


    }
}
