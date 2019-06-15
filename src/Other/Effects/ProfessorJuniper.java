package Other.Effects;

import Cards.IPokemon;
import Players.Trainer;

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
        //Hacer que bote su mano y tome 7 cartas
    }
}
