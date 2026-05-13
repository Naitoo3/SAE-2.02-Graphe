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
     *
     * La relation CONTIENT n'est pas prise en compte.
     */
    public static Set<IEntite> dependantsDirects(IGraphe graphe, IEntite cible) {

    }

    /**
     * Retourne les dépendants directs de la cible, puis remonte par contenance :
     * - à travers les types contenants éventuels ;
     * - jusqu'au premier paquetage rencontré, inclus ;
     * - sans jamais remonter au-delà de ce premier paquetage ;
     * - sans erreur si aucun paquetage englobant n'existe.
     */
    public static Set<IEntite> dependantsElargis(IGraphe graphe, IEntite cible) {

    }


}