package Abilities.Abilities;

import Abilities.Effects.IEffect;

import java.util.HashMap;

/**
 * @author fabiwave
 */

public class PokemonAbility extends AbstractAbility {

    public PokemonAbility(String name, String description, HashMap<String, Integer> energies,
                          IEffect effect) {
        this.name = name;
        this.description = description;
        this.energies = energies;
        this.effect = effect;
    }

    @Override
    public void useAbility() {
        if (this.checkCost()) {
            effect.executeBefore();
            effect.executeAfter();
        }
    }
}
