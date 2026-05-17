package TestsSprintFinal;

import grapheSprintFinal.impl.Graphe;
import grapheSprintFinal.modele.IGraphe;

public class AlgorithmesGrapheTest extends AbstractAlgorithmesGrapheTest {

    @Override
    protected IGraphe creerGrapheVide() {
        return new Graphe();
    }
}