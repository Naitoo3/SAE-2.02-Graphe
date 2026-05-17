package testSprint1;

import Graphe.GrapheMatriciel;

public class Test_GrapheMatriciel2 {

    public static void main(String[] args) {

        System.out.println("--- Test : Matrice 1x1 ---");
        GrapheMatriciel g1 = new GrapheMatriciel(1, 1);
        g1.setArc(1, 1);
        System.out.println(g1);

        System.out.println("--- Test : setArc puis supArc ---");
        GrapheMatriciel g2 = new GrapheMatriciel(3, 3);
        g2.setArc(1, 2);
        g2.setArc(2, 3);
        System.out.println("Après ajout de (1->2) et (2->3) :");
        System.out.println(g2);
        g2.supArc(1, 2);
        System.out.println("Après suppression de (1->2) :");
        System.out.println(g2);

        System.out.println("--- Test : supArc sur arc inexistant ---");
        GrapheMatriciel g3 = new GrapheMatriciel(3, 3);
        g3.supArc(2, 3);
        System.out.println("Après supArc sur arc inexistant (matrice doit rester vide) :");
        System.out.println(g3);

        System.out.println("--- Test : setArc en doublon ---");
        GrapheMatriciel g4 = new GrapheMatriciel(3, 3);
        g4.setArc(1, 3);
        g4.setArc(1, 3);
        System.out.println("Après double setArc(1,3) (doit afficher 1, pas 2) :");
        System.out.println(g4);

        System.out.println("--- Test : Matrice 3x3 entièrement remplie ---");
        GrapheMatriciel g5 = new GrapheMatriciel(3, 3);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                g5.setArc(i, j);
            }
        }
        System.out.println("Matrice pleine (toutes les cases à 1) :");
        System.out.println(g5);

        System.out.println("--- Test : Vider une matrice pleine ---");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                g5.supArc(i, j);
            }
        }
        System.out.println("Matrice après suppression de tous les arcs (toutes les cases à 0) :");
        System.out.println(g5);

        System.out.println("--- Test Erreur : Arc hors limites ---");
        GrapheMatriciel g6 = new GrapheMatriciel(3, 3);
        try {
            g6.setArc(0, 1);
            System.out.println("ERREUR : aucune exception levée pour setArc(0,1)");
        } catch (Exception e) {
            System.out.println("Exception correctement levée pour setArc(0,1) : " + e.getMessage());
        }
        try {
            g6.setArc(4, 1);
            System.out.println("ERREUR : aucune exception levée pour setArc(4,1)");
        } catch (Exception e) {
            System.out.println("Exception correctement levée pour setArc(4,1) : " + e.getMessage());
        }
    }
}