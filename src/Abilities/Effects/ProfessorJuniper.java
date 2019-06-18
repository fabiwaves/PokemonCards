package Abilities.Effects;

import Cards.IPokemon;
import Players.Trainer;

/**
 * @author fabiwave
 */

public class ProfessorJuniper extends AbstractAbilityEffect {
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

        //Hace que bote toda su mano
        trainer.setChangedObs();
        trainer.notifyObservers(100);
        //Hace que tome 7 cartas
        trainer.setChangedObs();
        trainer.notifyObservers(7);
    }
}
