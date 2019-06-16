package Abilities.Effects;

import Cards.IPokemon;
import Abilities.Abilities.Attack;
import Players.Trainer;
import Types.Type;

/**
 * @author fabiwave
 */

public class AttackDamageEffect extends AbstractAbilityEffect {

    public AttackDamageEffect(Attack attack) {
        this.ability = attack;
    }

    @Override
    public void executeBefore() {
        Attack attack = (Attack) this.ability;
        this.visitPokemon(attack.getTargetPokemon());
    }

    @Override
    public void executeAfter() {
        this.ability.getPokemon().getTrainer().notifyAttack();
    }

    @Override
    public void visitPokemon(IPokemon pokemon) {
        Attack attack = (Attack) this.ability;
        Type pokemon_type = attack.getPokemon().getType();
        int damage = attack.getDamage();
        damage = pokemon.getType().calcDamage(pokemon_type, damage);
        pokemon.setHp(pokemon.getHp() - damage);
    }

    @Override
    public void visitTrainer(Trainer trainer) {

    }
}
