package GrapheMethodes;

public class GrapheMatriciel {
    private int[][] matrice; // Définition d'une matrice à double dimensions.

    public GrapheMatriciel(int nbLignes, int nbColonnes){
        assert(nbLignes > 0 && nbColonnes > 0);
        matrice = new int[nbLignes][];
        for(int i = 0; i < nbLignes; i++){ // on met à 0 chaque valeur de la matrice en fonction de son nb de lignes et colonnes
            matrice[i] = new int[nbColonnes];
            for(int j = 0; j < nbColonnes; j++)
                matrice[i][j] = 0;
        }
    }

    /**
     * Ajoute une arrête à une ligne et à une colonne.
     * @param numLignes - Numéro de la ligne.
     * @param numColonnes - Numéro de la colonne.
     */
    public void setArc(int numLignes, int numColonnes){
        assert(numLignes >= 0 && numColonnes >= 0);
        matrice[numLignes - 1][numColonnes - 1] = 1;
    }

    /**
     * Supprime un arc au sein de la matrice avec son num de ligne/colonne.
     * @param numLignes - numéro de la ligne
     * @param numColonnes - numéro de la colonne
     */
    public void supArc(int numLignes, int numColonnes){
        assert(numLignes > 0 && numColonnes > 0);
        matrice[numLignes - 1][numColonnes - 1] = 0;
    }

    /**
     * Méthode ToString - parcours de la matrice pour représenter chaque sommet ainsi que ses arcs.
     * @return sb - un string représentant la matrice.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[i].length; j++){
                sb.append(matrice[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}