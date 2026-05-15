package grapheSprintFinal.outils;

import grapheSprintFinal.modele.IGraphe;
import grapheSprintFinal.modele.IEntite;
import grapheSprintFinal.modele.NatureRelation;
import grapheSprintFinal.modele.RelationEntrante;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class AlgorithmesGraphe {
    /**
     * Retourne les entités qui dépendent directement de la cible
     * via une seule arête de dépendance statique.
     * <p>
     * La relation CONTIENT n'est pas prise en compte.
     */
    public static Set<IEntite> dependantsDirects(IGraphe graphe, IEntite cible) {
        Set<IEntite> dependants = new HashSet<>(); // Création d'un HashSet vide.
        // Maintenant, on récupère toute les relations du graphe.
        Set<RelationEntrante> entrantes = graphe.relationsEntrantes(cible);
        for (RelationEntrante entrante : entrantes) {
            if (entrante.nature().estDependanceStatique()) {
                dependants.add(entrante.source());
            }
        }
        return dependants;
    }

    /**
     * Retourne les dépendants directs de la cible, puis remonte par contenance :
     * - à travers les types contenants éventuels ;
     * - jusqu'au premier paquetage rencontré, inclus ;
     * - sans jamais remonter au-delà de ce premier paquetage ;
     * - sans erreur si aucun paquetage englobant n'existe.
     */
    public static Set<IEntite> dependantsElargis(IGraphe graphe, IEntite cible) {
        Set<IEntite> Final = new HashSet<>(); // HashSet contenant le résultat final, dans lequel on ajoute à a fin les dépendances.
        Set<IEntite> dependants = dependantsDirects(graphe, cible); // appel autre fonction pour les dépendances

        for (IEntite dependant : dependants) {
            IEntite source = dependant; // Définition d'une nouvelle entité source affiliée à dépendant.
            while (source != null) {
                Final.add(source); // On l'ajoute
                if (!source.estType()) {
                    break;
                }
                IEntite target = null;
                for (RelationEntrante entrante : graphe.relationsEntrantes(dependant)) {
                    if (entrante.nature() == NatureRelation.CONTIENT) {
                        target = entrante.source();
                        break;
                    }
                }
                source = target;
            }
        }
        return  Final;
    }
}