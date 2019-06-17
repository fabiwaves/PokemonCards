package Cards.Energies;

import Cards.ICard;
import Controller.Game;
import Players.Trainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FightingEnergyTest {

    private Trainer trainer;
    private FightingEnergy energy;

    @Before
    public void setUp() {
        ArrayList<ICard> deck = new ArrayList<>();
        trainer = new Trainer(deck);
        energy = new FightingEnergy();
        energy.setTrainer(trainer);
    }

    @Test
    public void notifyType() {
        NullGame null_game = new NullGame();
        energy.notifyType(null_game);
        assertTrue(null_game.playEnergyCalled());
    }

    @Test
    public void getName() {
        assertEquals("Fighting Energy", energy.getName());
    }

    @Test
    public void setName() {
        energy.setName("test");
        assertEquals("test", energy.getName());
    }

    @Test
    public void getTrainer() {
        assertEquals(trainer, energy.getTrainer());
    }

    @Test
    public void setTrainer() {
        assertEquals(trainer, energy.getTrainer());
        energy.setTrainer(null);
        assertNull(energy.getTrainer());
    }

    private class NullGame extends Game {
        private boolean play_energy_called;

        NullGame() {
            super(null, null);
            this.play_energy_called = false;
        }

        @Override
        public void playFightingEnergy(IEnergy energy) {
            this.play_energy_called = true;
        }

        boolean playEnergyCalled() {
            return this.play_energy_called;
        }
    }
}