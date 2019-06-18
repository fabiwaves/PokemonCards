package Abilities.Effects;

import Cards.IPokemon;
import Players.Trainer;

import java.util.Random;

/**
 * @author fabiwave
 */

public class ElectricShock extends AbstractAbilityEffect {
    @Override
    public void executeBefore() {
    }

    @Override
    public void executeAfter() {
        IPokemon pokemon = this.ability.getPokemon();
        pokemon.acceptVisitor(this);
    }

    @Override
    public void visitPokemon(IPokemon pokemon) {
        Random random = new Random();
        if (random.nextInt(2) > 0) {
            int current_hp = pokemon.getHp();
            int new_hp = current_hp - 10;
            pokemon.setHp(new_hp);
        }
    }

    @Override
    public void visitTrainer(Trainer trainer) {

    }
}
