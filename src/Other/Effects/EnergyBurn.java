package Other.Effects;

import Cards.IPokemon;
import Players.Trainer;
import java.util.HashMap;

public class EnergyBurn extends AbstractAbilityEffect {

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
        HashMap<String, Integer> energies = pokemon.getEnergies();
        String type_name = pokemon.getType().getName();
        int current_energy_amount;
        for (String type : energies.keySet()) {
            current_energy_amount = energies.get(type);
            energies.replace(type, 0);
            energies.replace(type_name, energies.get(type_name) + current_energy_amount);
        }
    }

    @Override
    public void visitTrainer(Trainer trainer) {

    }
}
