package grapheSprintFinal.impl;


import grapheSprintFinal.modele.IGraphe;
import grapheSprintFinal.modele.AbstractIGrapheTest;

public class GrapheTest extends AbstractIGrapheTest {

    @Override
    protected IGraphe creerGrapheVide() {
        return new Graphe();
    }
}