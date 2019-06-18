package Cards.TrainerCards;

import Controller.Game;
import Players.Trainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class SupportTest {

    private Support support;

    @Before
    public void setUp() {
        support = new Support(null);
    }

    @Test
    public void notifyType() {
        NullGame game = new NullGame();
        support.notifyType(game);
        assertTrue(game.playSupportCalled());
    }

    private class NullGame extends Game {
        private boolean play_support_called;

        NullGame() {
            super(new Trainer(new ArrayList<>()), new Trainer(new ArrayList<>()));
            this.play_support_called = false;
        }

        @Override
        public void playSupport(Support support) {
            this.play_support_called = true;
        }

        boolean playSupportCalled() {
            return this.play_support_called;
        }
    }
}