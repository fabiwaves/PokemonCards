package Other.Abilities;

import Cards.IPokemon;
import Other.Effects.IEffect;

import java.util.HashMap;

public class PokemonAbility extends AbstractAbility {

    public PokemonAbility(String name, String description, HashMap<String, Integer> energies,
                          IEffect effect, IPokemon pokemon) {
        this.name = name;
        this.description = description;
        this.energies = energies;
        this.effect = effect;
        this.pokemon = pokemon;
    }

    @Override
    public void useAbility() {
        effect.executeBefore();
        effect.executeAfter();
    }
}
