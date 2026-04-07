package Graphe;

public class GrapheListeAdjacenceTest {

    public static void main(String[] args) {
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
}
