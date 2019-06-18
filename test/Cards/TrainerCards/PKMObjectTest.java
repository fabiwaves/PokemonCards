package Cards.TrainerCards;

import Cards.IPokemon;
import Cards.Pokemon;
import Controller.Game;
import Players.Trainer;
import Types.Fire;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PKMObjectTest {

    private PKMObject object, object2;
    private IPokemon pokemon;

    @Before
    public void setUp() {
        object = new PKMObject(null);
        object2 = new PKMObject(null);
        pokemon = new Pokemon("test", 12, 45, new ArrayList<>(), new Fire(), null, null);
    }

    @Test
    public void getCurrentPokemon() {
        assertNull(object.getCurrentPokemon());
    }

    @Test
    public void setCurrentPokemon() {
        assertTrue(object.setCurrentPokemon(pokemon));
        pokemon.setPkmObject(object);
        assertFalse(object2.setCurrentPokemon(pokemon));
    }

    @Test
    public void notifyType() {
        NullGame game = new NullGame();
        object.notifyType(game);
        assertTrue(game.playPKMObjectCalled());
    }

    @Test
    public void getDescription() {
        assertNull(object.getDescription());
    }

    @Test
    public void setDescription() {
        object.setDescription("test");
        assertEquals("test", object.getDescription());
    }

    @Test
    public void getName() {
        assertNull(object.getName());
    }

    @Test
    public void setName() {
        object.setName("test");
        assertEquals("test", object.getName());
    }

    @Test
    public void getTrainer() {
        assertNull(object.getTrainer());
    }

    @Test
    public void setTrainer() {
        Trainer trainer = new Trainer(new ArrayList<>());
        object.setTrainer(trainer);
        assertEquals(trainer, object.getTrainer());
    }

    private class NullGame extends Game {
        private boolean play_pkmobject_called;

        NullGame() {
            super(new Trainer(new ArrayList<>()), new Trainer(new ArrayList<>()));
            this.play_pkmobject_called = false;
        }

        @Override
        public void playPKMObject(PKMObject pkm_object) {
            this.play_pkmobject_called = true;
        }

        boolean playPKMObjectCalled() {
            return this.play_pkmobject_called;
        }
    }
}