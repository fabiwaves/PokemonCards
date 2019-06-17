package Abilities.Abilities;

import Abilities.Effects.AttackDamageEffect;
import Abilities.Effects.IEffect;
import Cards.IPokemon;
import Players.Trainer;

import java.util.HashMap;

/**
 * @author Fabiwave
 */

public class Attack extends AbstractAbility {
    private int damage;
    private AttackDamageEffect dmg_effect;
    private IPokemon target_pokemon;

    public Attack(
            String name, int damage, String description, HashMap<String, Integer> energies,
            IEffect effect, IPokemon pokemon
    ) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.energies = energies;
        this.effect = effect;
        this.pokemon = pokemon;
        this.target_pokemon = null;
        this.dmg_effect = new AttackDamageEffect(this);
    }

    /**
     * Gives the damage of the attack
     *
     * @return the damage of the attack
     */
    public int getDamage() {
        return damage;
    }

    public IPokemon getTargetPokemon() {
        return this.target_pokemon;
    }

    public void useAbility() {
        if (this.checkCost()) {
            Trainer trainer = this.pokemon.getTrainer();
            Trainer target = trainer.getAdversary();
            this.target_pokemon = target.getActivePokemon();

            this.effect.executeBefore();

            this.dmg_effect.executeBefore();
            this.dmg_effect.executeAfter();

            this.effect.executeAfter();

            this.target_pokemon = null;
        }
    }

}
