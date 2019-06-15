package Other.Effects;

import Cards.IPokemon;
import Players.Trainer;

public class ElectricShock extends AbstractAbilityEffect {
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
        int current_hp =pokemon.getHp();
        int new_hp = current_hp - 10;
        pokemon.setHp(new_hp);

    }

    @Override
    public void visitTrainer(Trainer trainer) {

    }
}
