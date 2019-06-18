package Cards.TrainerCards;

import Abilities.Effects.AbstractStadiumEffect;
import Cards.IPokemon;
import Controller.Game;
import Players.Trainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Observable;

import static org.junit.Assert.assertTrue;

public class StadiumTest {

    private class NullGame extends Game {
        private boolean play_stadium_called;

        NullGame() {
            super(new Trainer(new ArrayList<>()), new Trainer(new ArrayList<>()));
            this.play_stadium_called = false;
        }

        @Override
        public void playStadium(Stadium stadium) {
            this.play_stadium_called = true;
        }

        boolean playStadiumCalled() {
            return this.play_stadium_called;
        }
    }

    private class NullStadiumEffect extends AbstractStadiumEffect {

        @Override
        public void executeBefore() {
        }

        @Override
        public void executeAfter() {
        }

        @Override
        public void visitPokemon(IPokemon pokemon) {
        }

        @Override
        public void visitTrainer(Trainer trainer) {
        }

        @Override
        public void update(Observable o, Object arg) {
        }
    }

    private Stadium stadium;

    @Before
    public void setUp() {
        NullStadiumEffect null_effect = new NullStadiumEffect();
        stadium = new Stadium(null_effect);
    }

    @Test
    public void notifyType() {
        NullGame game = new NullGame();
        stadium.notifyType(game);
        assertTrue(game.playStadiumCalled());
    }
}