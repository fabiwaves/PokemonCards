package Abilities.Abilities;

import Cards.IPokemon;
import Abilities.Effects.IEffect;

import java.util.HashMap;

/**
 * @author fabiwave
 */

public abstract class AbstractAbility implements IAbility {
    String name;
    String description;
    IEffect effect;
    IPokemon pokemon;
    HashMap<String, Integer> energies;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean checkCost() {
        boolean result = true;
        HashMap<String, Integer> pkmn_energies = this.pokemon.getEnergies();
        for (String energy : this.energies.keySet()) {
            if (this.energies.get(energy) > pkmn_energies.get(energy)) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public IPokemon getPokemon() {
        return this.pokemon;
    }

    @Override
    public void setPokemon(IPokemon pokemon){
        this.pokemon = pokemon;
    }

}
