package TestsSprintFinal;


import grapheSprintFinal.impl.Graphe;
import grapheSprintFinal.modele.IGraphe;

public class GrapheTest extends AbstractIGrapheTest {

    @Override
    protected IGraphe creerGrapheVide() {
        return new Graphe();
    }
}