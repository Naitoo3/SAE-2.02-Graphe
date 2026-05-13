package graphe;
import modele.IGraphe;
import modele.IEntite;
import modele.RelationSortante;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Graphe  implements IGraphe{
    private final Map<IEntite, Set<RelationSortante>> ListeAdjacence;

    public Graphe(){
        this.ListeAdjacence = new HashMap<>();
    }

    @Override
    public boolean AjouterEntite(IEntite entite) {
        // Vérification au préalable de la présence d'une entité et de l'ajout dans le graphe.
        if(!ListeAdjacence.containsKey(entite)) {
            this.ListeAdjacence.put(entite, new HashSet<>());
            return true;
        }
        return false;
    }

    @Override



}
