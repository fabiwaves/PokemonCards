package Cards.Phases;

import Cards.IPokemon;

/**
 * @author fabiwave
 */

public class Phase2 extends AbstractPhase {

    public Phase2(int prev1, int prev2) {
        this.prev_pokemon_id1 = prev1; //referencia a Phase1
        this.prev_pokemon_id2 = prev2; //referencia a basico
    }

    /**
     * Checks if a pokemon is the pre-evolution of this phase by the id
     *
     * @param pokemon that wants to be checkes
     * @return true if it is the pokemon, false otherwise
     */
    @Override
    public boolean checkPrevId1(IPokemon pokemon) {
        return (this.prev_pokemon_id1 == pokemon.getId());
    }

    /**
     * Checks if a pokemon is the pre-pre-evolution of this phase by the id
     *
     * @param pokemon that wants to be checkes
     * @return true if it is the pokemon, false otherwise
     */
    @Override
    public boolean checkPrevId2(IPokemon pokemon) {
        return (this.prev_pokemon_id2 == pokemon.getId());
    }

    @Override
    public boolean isEvolution() {
        return true;
    }
}
