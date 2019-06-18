package Abilities.Effects;

import Cards.IPokemon;
import Cards.TrainerCards.Support;
import Players.Trainer;

/**
 * @author fabiwave
 */

public class Potion implements IEffect {
    private Support support;

    void setSupport(Support support) {
        this.support = support;
    }

    @Override
    public void executeBefore() {

        IPokemon pokemon = this.support.getTrainer().selectOwnPokemonTarget();
        pokemon.acceptVisitor(this);
    }

    @Override
    public void executeAfter() {

    }

    @Override
    public void visitPokemon(IPokemon pokemon) {
        int max_hp = pokemon.getMax_hp();
        int current_hp = pokemon.getHp();
        /* Contadores perdidos por el pokemon */
        int counter = (max_hp - current_hp) / 10;
        int random = (int) (Math.random() * current_hp + 1);
        pokemon.setHp(random * 10);

    }

    @Override
    public void visitTrainer(Trainer trainer) {

    }
}
