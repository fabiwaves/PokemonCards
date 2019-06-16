package Other.Effects;

import Cards.IPokemon;
import Players.Trainer;

/**
 * @author fabiwave
 */

public class LuckyStadium extends AbstractAbilityEffect {


    @Override
    public void executeBefore() {
        Trainer trainer = this.ability.getPokemon().getTrainer();
        trainer.acceptVisitor(this);
    }

    @Override
    public void executeAfter() {
    }

    @Override
    public void visitPokemon(IPokemon pokemon) {

    }

    @Override
    public void visitTrainer(Trainer trainer) {
        //While this Stadium Card is active in the game, the player can take an extra card
        trainer.notifyObservers(2);

    }
}
