package Other.Effects;

import Cards.IPokemon;
import Players.Trainer;

/**
 * @author fabiwave
 */

public class Potion extends AbstractAbilityEffect {
    @Override
    public void executeBefore() {

        IPokemon pokemon = this.ability.getPokemon();
        pokemon.acceptVisitor(this);
    }

    @Override
    public void executeAfter() {

    }

    @Override
    public void visitPokemon(IPokemon pokemon) {
        int max_hp = this.ability.getPokemon().getMax_hp();
        int current_hp = this.ability.getPokemon().getHp();
        /* Contadores perdidos por el pokemon */
        int counter = (max_hp - current_hp) / 10;
        int random = (int) (Math.random() * current_hp + 1);
        pokemon.setHp(random * 10);

    }

    @Override
    public void visitTrainer(Trainer trainer) {

    }
}
