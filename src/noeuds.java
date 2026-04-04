import java.util.HashMap;
import java.util.Map;

public class noeuds {
    private String etiquetteSommet;
    private Map<String, String> Graphe; // Pas encore sur de l'implémentation ici
    private Map<String, String> successeurs;
    private Map<String, String> predecesseurs;


    public noeuds(String etiquetteSommet) {
        this.etiquetteSommet = etiquetteSommet;
        this.Graphe = new HashMap<>();
        this.successeurs = new HashMap<>();
        this.predecesseurs = new HashMap<>();
    }
    /*
    * Ajoute un sucesseur au sein d'un graphe.
    * @param nomSommet le nom du sommet au choix
    * @param etiquetteLien le lien du sommet A au sommet B
     */
    public void ajouterSuccesseur(String nomSommet, String etiquetteLien) {
        successeurs.put(nomSommet, etiquetteLien);
        if (etiquetteLien != null) {
            etiquetteLien = "";
        }
    }

    /*
    * Ajoute un prédecesseur
    * @param nomSommet le nom du sommet choisi
    * @param etiquetteLien le lien vers le sommet
     */
    public void ajouterPredecesseur(String nomSommet, String etiquetteLien) {
        predecesseurs.put(nomSommet, etiquetteLien);
        if (etiquetteLien != null) {
            etiquetteLien = "";
        }
    }
    public String toString(){
    }
    public String getEtiquetteSommet() {
        return etiquetteSommet;
    }

    public Map<String, String> getSuccesseurs() {
        return successeurs;
    }

    public Map<String, String> getPredecesseurs() {
        return predecesseurs;
    }
}