package Graphe;

public class GrapheMatriciel {
    private int[][] matrice;

    //methods
    public GrapheMatriciel(int nbL, int nbC){
        assert(nbL > 0 && nbC > 0);
        matrice = new int[nbL][];
        for(int i = 0; i < nbL; i++){
            matrice[i] = new int[nbC];
            for(int j = 0; j < nbC; j++)
                matrice[i][j] = 0;
        }
    }

    public void setArc(int numL, int numC){
        assert(numL > 0 && numC > 0);
        matrice[numL - 1][numC - 1] = 1;
    }
    public void supArc(int numL, int numC){
        assert(numL > 0 && numC > 0);
        matrice[numL - 1][numC - 1] = 0;
    }

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