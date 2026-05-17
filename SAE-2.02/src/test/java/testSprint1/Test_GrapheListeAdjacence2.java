package testSprint1;

import Graphe.GrapheListe;

public class Test_GrapheListeAdjacence2 {

    public static void main(String[] args) {
        System.out.println("--- Test : Graphe vide ---");
        GrapheListe monGraphe = new GrapheListe("Vide");
        monGraphe.nodes(); // doit afficher une liste vide

        System.out.println("\n--- Test : Ajout d'un nœud en doublon ---");
        GrapheListe g = new GrapheListe("Racine");
        g.addNode("A");
        g.addNode("A");
        g.nodes();

        System.out.println("\n--- Test : Boucle A -> A ---");
        g.addEdge("A", "A");
        g.neighbors("A");

        System.out.println("\n--- Test : Arête en doublon A -> B ---");
        g.addNode("B");
        g.addEdge("A", "B");
        g.addEdge("A", "B");
        g.neighbors("A");

        System.out.println("\n--- Test : Nœud isolé C (aucun voisin) ---");
        g.addNode("C");
        g.neighbors("C");

        System.out.println("\n--- Test : Chaîne linéaire ---");
        GrapheListe chaine = new GrapheListe("Chaine");
        chaine.addNode("A");
        chaine.addNode("B");
        chaine.addNode("C");
        chaine.addNode("D");
        chaine.addEdge("A", "B");
        chaine.addEdge("B", "C");
        chaine.addEdge("C", "D");

        System.out.println("Voisins de A (doit afficher B) :");
        chaine.neighbors("A");
        System.out.println("Voisins de B (doit afficher C) :");
        chaine.neighbors("B");
        System.out.println("Voisins de D (doit être vide, nœud terminal) :");
        chaine.neighbors("D");

        System.out.println("\n--- Test : Étoile Centre -> A, B, C, D ---");
        GrapheListe etoile = new GrapheListe("Etoile");
        etoile.addNode("Centre");
        etoile.addNode("A");
        etoile.addNode("B");
        etoile.addNode("C");
        etoile.addNode("D");
        etoile.addEdge("Centre", "A");
        etoile.addEdge("Centre", "B");
        etoile.addEdge("Centre", "C");
        etoile.addEdge("Centre", "D");

        System.out.println("Voisins de Centre (doit afficher A, B, C, D) :");
        etoile.neighbors("Centre");
        System.out.println("Voisins de A (doit être vide, pas de sortie) :");
        etoile.neighbors("A");

        System.out.println("\n--- Test : contains sur nœud inexistant ---");
        System.out.println("Contient 'Z' ? (doit être false) : " + etoile.contains("Z"));
        System.out.println("Contient 'Centre' ? (doit être true) : " + etoile.contains("Centre"));

        System.out.println("\n--- Test Erreur : neighbors sur nœud inexistant ---");
        chaine.neighbors("Z");
    }
}