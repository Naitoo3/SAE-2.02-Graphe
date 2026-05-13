
package grapheSprintFinal.impl;

import grapheSprintFinal.modele.*;
import java.util.*;

    public final class Graphe implements IGraphe {

        private final Set<IEntite> entites = new HashSet<>();
        private final Map<IEntite, Set<RelationSortante>> sortantes = new HashMap<>();
        private final Map<IEntite, Set<RelationEntrante>> entrantes = new HashMap<>();

        @Override
        public boolean ajouterEntite(IEntite entite) {
            return entites.add(entite);
        }

        @Override
        public boolean ajouterRelation(IEntite source, IEntite cible, NatureRelation nature) {
            // Ajouter automatiquement les entités si absentes
            ajouterEntite(source);
            ajouterEntite(cible);

            RelationSortante rs = new RelationSortante(cible, nature);
            RelationEntrante re = new RelationEntrante(source, nature);

            sortantes.computeIfAbsent(source, k -> new HashSet<>());
            entrantes.computeIfAbsent(cible, k -> new HashSet<>());

            boolean ajoutee = sortantes.get(source).add(rs);
            entrantes.get(cible).add(re);

            return ajoutee;
        }

        @Override
        public Set<IEntite> entites() {
            return Collections.unmodifiableSet(entites);
        }

        @Override
        public Set<RelationSortante> relationsSortantes(IEntite source) {
            return Collections.unmodifiableSet(
                    sortantes.getOrDefault(source, Collections.emptySet())
            );
        }

        @Override
        public Set<RelationEntrante> relationsEntrantes(IEntite cible) {
            return Collections.unmodifiableSet(
                    entrantes.getOrDefault(cible, Collections.emptySet())
            );
        }
        public static Set<IEntite> dependantsDirects(IGraphe graphe, IEntite cible) {
            Set<IEntite> resultat = new HashSet<>();
            for (RelationEntrante r : graphe.relationsEntrantes(cible)) {
                if (r.nature().estDependanceStatique()) {
                    resultat.add(r.source());
                }
            }
            return resultat;
        }

        public static Set<IEntite> dependantsElargis(IGraphe graphe, IEntite cible) {
            Set<IEntite> resultat = new HashSet<>();

            for (IEntite dependant : dependantsDirects(graphe, cible)) {
                resultat.add(dependant);
                remonterContenance(graphe, dependant, resultat);
            }

            return resultat;
        }

        private static void remonterContenance(IGraphe graphe, IEntite entite, Set<IEntite> resultat) {
            for (RelationEntrante r : graphe.relationsEntrantes(entite)) {
                if (r.nature() == NatureRelation.CONTIENT) {
                    IEntite parent = r.source();
                    resultat.add(parent);
                    // On s'arrête au premier paquetage (estType() == false)
                    if (parent.estType()) {
                        // C'est un type (classe/interface), on continue de remonter
                        remonterContenance(graphe, parent, resultat);
                    }
                    // Si c'est un paquetage (!estType()), on l'a ajouté et on s'arrête
                }
            }
        }
    }

