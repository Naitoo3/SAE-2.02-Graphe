
import graphe.GrapheMatriciel;
import org.junit.jupiter.api.Test;

public class Test_GrapheMatriciel {
    @Test
    public void testMatrice() {
        GrapheMatriciel gm = new GrapheMatriciel(5,5);
        gm.setArc(1,3);
        System.out.println(gm);
        gm.setArc(1,3);
        gm.setArc(5,4);
        gm.setArc(3,2);
        gm.supArc(1,3);
        gm.setArc(5,5);
        System.out.println(gm);
    }
}