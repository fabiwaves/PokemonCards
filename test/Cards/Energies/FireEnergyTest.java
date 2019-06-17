package Cards.Energies;

import Controller.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FireEnergyTest {

    private FireEnergy energy;

    @Before
    public void setUp() {
        energy = new FireEnergy();
    }

    @Test
    public void notifyType() {
        NullGame game = new NullGame();
        energy.notifyType(game);
        assertTrue(game.playEnergyCalled());
    }

    private class NullGame extends Game {
        private boolean play_energy_called;

        NullGame() {
            super(null, null);
            this.play_energy_called = false;
        }

        @Override
        public void playFireEnergy(IEnergy energy) {
            this.play_energy_called = true;
        }

        boolean playEnergyCalled() {
            return this.play_energy_called;
        }
    }
}