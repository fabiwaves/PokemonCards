package Abilities.Effects;

import Cards.AbstractCard;
import Cards.Energies.FireEnergy;
import Cards.ICard;
import Controller.Game;
import Players.Trainer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LuckyStadiumTest {

    private class NullGame extends Game {

        private int get_current_player_times;

        public NullGame(Trainer player1) {
            super(player1, player1);
            this.get_current_player_times = 0;
        }

        @Override
        public Trainer getCurrentPlayer() {
            this.get_current_player_times += 1;
            return super.getCurrentPlayer();
        }

        int getCurrentPlayerTimes() {
            return this.get_current_player_times;
        }
    }

    private class NullCard extends AbstractCard {

        @Override
        public void notifyType(Game game) {
            game.playFireEnergy(new FireEnergy());
        }
    }

    private LuckyStadium lucky;
    private Trainer trainer;
    private ArrayList<ICard> null_cards;
    private NullGame game;

    @Before
    public void setUp() {
        lucky = new LuckyStadium();
        ArrayList<ICard> deck = new ArrayList<>();
        null_cards = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            NullCard null_card = new NullCard();
            null_cards.add(null_card);
            deck.add(null_card);
        }
        trainer = new Trainer(deck);
        game = new NullGame(trainer);
    }

    @Test
    public void executeBefore() {
        // This method does nothing
        lucky.executeBefore();
        assertTrue(true);
    }

    @Test
    public void executeAfter() {
        // This method does nothing
        lucky.executeBefore();
        assertTrue(true);
    }

    @Test
    public void visitPokemon() {
        // This method does nothing
        lucky.executeBefore();
        assertTrue(true);
    }

    @Test
    public void visitTrainer() {
        lucky.visitTrainer(trainer);
        assertEquals(trainer.getHand().get(0), null_cards.get(0));
    }

    @Test
    public void update() {
        lucky.update(game, 0);
        lucky.update(game, 1);
        lucky.update(game, 1);
        assertEquals(1, game.getCurrentPlayerTimes());
        lucky.update(game, 1);
        assertEquals(1, game.getCurrentPlayerTimes());
    }

    @Test
    public void setStadium() {
        lucky.setStadium(null);
        assertNull(lucky.stadium_card);
    }
}