package Cards.TrainerCards;

import Controller.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SupportTest {

    private class NullGame extends Game {
        private boolean play_support_called;

        NullGame() {
            super(null, null);
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

    private Support support;

    @Before
    public void setUp(){
        support = new Support(null);
    }

    @Test
    public void notifyType() {
        NullGame game = new NullGame();
        support.notifyType(game);
        assertTrue(game.playSupportCalled());
    }
}