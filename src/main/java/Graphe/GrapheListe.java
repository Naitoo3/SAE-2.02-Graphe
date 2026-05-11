package Graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
 *Représentation d'un graphe à l'aide d'une , pour faire une liste d'adjacence.
 */
public class GrapheListe {
    private final String etiquetteSommet;
    private final ArrayList<String> successeurs;
    private final Map<String, GrapheListe> sommetsListe;


    public GrapheListe(String etiquetteSommet) {
        this.etiquetteSommet = etiquetteSommet;
        this.sommetsListe= new HashMap<>();
        this.successeurs = new ArrayList<>();
    }
    /*
     * Ajoute un sucesseur au sein d'un graphe.
     * @param nomSommet le nom du sommet au choix
     * @param etiquetteLien le lien du sommet A au sommet B
     */
    public boolean addNode(String NodeName) {
        if(!this.sommetsListe.containsKey(NodeName)) {
            this.sommetsListe.put(NodeName, new GrapheListe(NodeName));
            return true;
        }
        return false; // Si le sommet n'a pas pu etre ajoute dans le graphe.
    }
    /*
     Ajoute un arc entre un sommet A et sommet B, sans pondération
     @param NodeA Le sommet de départ
     @param NodeB le sommet de fin
     */
    public void addEdge(String NodeA, String NodeB) {
        GrapheListe SourceNode = this.sommetsListe.get(NodeA);
        GrapheListe EndNode = this.sommetsListe.get(NodeB);
        if(SourceNode != null && EndNode != null) {
            if(!SourceNode.getSuccesseurs().contains(NodeB)) {
                SourceNode.getSuccesseurs().add(NodeB);
            } else {
                System.out.println("Erreur d'ajout de l'arrete");
            }
        }
    }
    /*
     * Affiche les voisins d'un noeud par le biais d'un itérateur
     * @param Node
     */
    public void neighbors(String Node) {
        GrapheListe SommetCible = this.sommetsListe.get(Node);
        if (SommetCible != null) {
            System.out.println("voisins du " + SommetCible);
        } else {
            System.out.println("Le sommet " + Node + " N'existe pas dans ce graphe.");
        }
    }

    /*
     * Vérifie si le sommet entré en paramètre est bien présent dans le graphe, et retourne true si vrai, false sinon.
     * @param Node
     * @return True si vrai, false sinon.
     */
    public boolean contains(String Node) {
        return this.sommetsListe.containsKey(Node); // Si le sommet est bien présent, il retourne true, sinon false.
    }
    /*
     * Affiche la liste de tous les sommets enregistres dans un graphe sans ordre particulier.
     */
    public void nodes() {
        System.out.println("Liste des sommets :");
        System.lineSeparator();
        for (String nomSommet : this.sommetsListe.keySet()) {
            System.out.println("- " + nomSommet);
        }


    }

    @Override
    // Representation textuelle du graphe en forme de liste d'adjacence.
    public String toString() {
        return "Sommet '" + etiquetteSommet + "' -> successeurs: " + successeurs;
    }
    //Getters
    public String getEtiquetteSommet() {
        return etiquetteSommet;
    }
    public ArrayList<String> getSuccesseurs() {
        return this.successeurs;
    }
    public Map<String, GrapheListe> getSommetsListe() {
        return this.sommetsListe;
    }
}