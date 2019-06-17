package Abilities.Effects;

import Cards.IPokemon;
import Cards.TrainerCards.Stadium;
import Controller.Game;
import Players.Trainer;

import java.util.Observable;
import java.util.Random;

/**
 * @author fabiwave
 */

public class LuckyStadium extends AbstractStadiumEffect {

    private boolean new_turn;
    private boolean used_this_turn;
    private Random random;

    public LuckyStadium(Stadium stadium){
        this.new_turn = false;
        this.used_this_turn = false;
        this.random = new Random();
    }

    @Override
    public void executeBefore() {
        // Possible setup for the stadium
    }

    @Override
    public void executeAfter() {
        // Possible teardown for the stadium
    }

    @Override
    public void visitPokemon(IPokemon pokemon) {
    }

    @Override
    public void visitTrainer(Trainer trainer) {
        trainer.getHand().add(trainer.getDeck().remove(0));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals(0)){
            this.new_turn = true;
            this.used_this_turn = false;
        }

        if (arg.equals(1)){
            if (this.new_turn){
                this.new_turn = false;
            } else {
                if (!this.used_this_turn) {
                    this.used_this_turn = true;
                    Game game = (Game) o;
                    Trainer trainer = (Trainer) game.getCurrentPlayer();
                    if (random.nextInt(2) > 0){
                        this.visitTrainer(trainer);
                    }
                }
            }
        }
    }
}
