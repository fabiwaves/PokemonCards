package Cards.Phases;

import Cards.IPokemon;
import Cards.Pokemon;
import Types.Fire;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Phase2Test {

    private Phase2 phase2;
    private IPokemon pokemon;
    private IPokemon pokemon2;

    @Before
    public void setUp() {
        phase2 = new Phase2(12, 11);
        pokemon = new Pokemon("test", 11, 45, new ArrayList<>(), new Fire(), null, null);
        pokemon2 = new Pokemon("test2", 12, 45, new ArrayList<>(), new Fire(), null, null);
    }

    @Test
    public void checkPrevId1() {
        assertTrue(phase2.checkPrevId1(pokemon2));
        assertFalse(phase2.checkPrevId1(pokemon));
    }

    @Test
    public void checkPrevId2() {
        assertTrue(phase2.checkPrevId2(pokemon));
        assertFalse(phase2.checkPrevId2(pokemon2));
    }

    @Test
    public void isEvolution() {
        assertTrue(phase2.isEvolution());
    }
}