package GrapheMethodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class GrapheListe {
    private final String etiquetteSommet;
    private final ArrayList<String> successeurs;
    private final Map<String, GrapheListe> sommetsListe;


    public GrapheListe(String etiquetteSommet) {
        this.etiquetteSommet = etiquetteSommet;
        this.sommetsListe= new HashMap<>();
        this.successeurs = new ArrayList<>();
    }

    /**
     * Ajoute un sommet au sein d'un graphe vide.
      * @param NodeName - Un sommet
     * @return true si il est ajouté, false si le sommet existe déjà
     */
    public boolean addNode(String NodeName) {
        if(!this.sommetsListe.containsKey(NodeName)) {
            this.sommetsListe.put(NodeName, new GrapheListe(NodeName));
            return true;
        }
        return false; // Si le sommet n'a pas pu etre ajoute dans le graphe.
    }

    /**
     * Ajoute un arc entre deux sommets respectifs.
     * @param NodeA - Le sommet A
     * @param NodeB - Le sommet B
     * @return True - si l'arc est ajouté entre les deux sommets, False si l'arc n'a pas été ajouté.
     */
    public boolean addEdge(String NodeA, String NodeB) {
        // On récupère le sommet source, ainsi que le sommet cible.
        GrapheListe SourceNode = this.sommetsListe.get(NodeA);
        GrapheListe EndNode = this.sommetsListe.get(NodeB);

        // vérifie que les deux sommets ne sont pas nul
        if(SourceNode == null || EndNode == null) {
            // Vérifie que les sommets sont présents dans le graphe

            if(!SourceNode.getSuccesseurs().contains(NodeB)) {
                SourceNode.getSuccesseurs().add(NodeB); // ajoute l'arc et retourne vraie.
                return true;
            } else {
                System.out.println("Erreur d'ajout de l'arrete");

            }
        }
        return false;
    }
    /**
     * Affiche les voisins d'un noeud par le biais d'un itérateur
     * @param Node
     **/
    public void neighbors(String Node) {
        GrapheListe SommetCible = this.sommetsListe.get(Node);
        if (SommetCible != null) {
            System.out.println("voisins du " + SommetCible);
        } else {
            System.out.println("Le sommet " + Node + " N'existe pas dans ce graphe.");
        }
    }

    /**
     * Indique si le sommet est bien présent au sein du graphe.
     * @param Node - Un sommet
     * @return True/False si le sommet est présent où pas dans le graphe.
     */
    public boolean contains(String Node) {
        return this.sommetsListe.containsKey(Node); // Si le sommet est bien présent, il retourne true, sinon false.
    }
    /**
     * Affiche la liste de tous les sommets enregistres dans un graphe sans ordre particulier.
     **/
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
    //Getter
    public ArrayList<String> getSuccesseurs() {
        return this.successeurs;
    }

}