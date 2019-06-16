package Other.Effects;

import Cards.IPokemon;
import Players.Trainer;

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
        //Notifica que puede tomar una carta extra, mientras el stadium esté activo en el juego
        trainer.notifyObservers(2);

    }
}
