package Cards.Phases;

import Cards.IPokemon;
import Cards.Pokemon;
import Types.Fire;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BasicTest {

    private Basic basic;
    private IPokemon pokemon;

    @Before
    public void setUp() {
        basic = new Basic();
        pokemon = new Pokemon("test", 12, 45, new ArrayList<>(), new Fire(), null, null);
    }

    @Test
    public void isEvolution() {
        assertFalse(basic.isEvolution());
    }

    @Test
    public void getPrev_pokemon_id() {
        assertEquals(-1, basic.getPrev_pokemon_id());
    }

    @Test
    public void getPrev_pokemon_id2() {
        assertEquals(-1, basic.getPrev_pokemon_id2());
    }

    @Test
    public void checkPrevId1() {
        assertFalse(basic.checkPrevId1(pokemon));
    }

    @Test
    public void checkPrevId2() {
        assertFalse(basic.checkPrevId2(pokemon));
    }
}