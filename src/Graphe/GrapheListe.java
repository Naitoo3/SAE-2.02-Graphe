package Graphe;

import java.util.ArrayList;
import java.util.HashMap;
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
    public void addEdge(String NodeA, String NodeB) {
        //Vérifie si le noeud n'est pas déjà dans le graphe.
        // IMPLEMENTER VERIFICATION.
       GrapheListe SourceNode = this.sommetsListe.get(NodeA);
       SourceNode.addNode(NodeB);
    }
    /*
       * Affiche les voisins d'un noeud par le biais d'un itérateur
       * @param Node
     */
    public void neighbors(String Node) {

    }
    public void contains(String Node) {

    }
    public void nodes() {

    }

    @Override
    public String toString() {
        return "Liste des sommets du graphe " +
                "Sommet '" + etiquetteSommet + '\'' +
                " sucesseurs " + successeurs +
                '}';
    }

    public String getEtiquetteSommet() {
        return etiquetteSommet;
    }
    public ArrayList<String> getSuccesseurs() {return this.successeurs;}
    public Map<String, GrapheListe> getSommetsListe() {return this.sommetsListe;}
}