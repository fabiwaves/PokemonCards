package Cards.Phases;

import Cards.IPokemon;
import Cards.Pokemon;
import Types.Fire;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Phase1Test {

    private Phase1 phase1;
    private IPokemon pokemon;
    private IPokemon pokemon2;

    @Before
    public void setUp() {
        phase1 = new Phase1(12);
        pokemon = new Pokemon("test", 12, 45, new ArrayList<>(), new Fire(), null, null);
        pokemon2 = new Pokemon("test2", 13, 45, new ArrayList<>(), new Fire(), null, null);
    }

    @Test
    public void checkPrevId1() {
        assertTrue(phase1.checkPrevId1(pokemon));
        assertFalse(phase1.checkPrevId1(pokemon2));
    }

    @Test
    public void isEvolution() {
        assertTrue(phase1.isEvolution());
    }
}