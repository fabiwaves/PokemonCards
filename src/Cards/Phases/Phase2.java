package Cards.Phases;

import Cards.IPokemon;

public class Phase2 extends AbstractPhase {

    public Phase2(int prev1, int prev2) {
        this.prev_pokemon_id1 = prev1;
        this.prev_pokemon_id2 = prev2;
    }

    /**
     * Checks if a pokemon is the pre-evolution of this phase by the id
     * @param pokemon that wants to be checkes
     * @return true if it is the pokemon, false otherwise
     */
    public boolean check_prev_id1(IPokemon pokemon){
        return (this.prev_pokemon_id1 == pokemon.getId());
    }

    /**
     * Checks if a pokemon is the pre-pre-evolution of this phase by the id
     * @param pokemon that wants to be checkes
     * @return true if it is the pokemon, false otherwise
     */
    public boolean check_prev_id2(IPokemon pokemon){
        return (this.prev_pokemon_id2 == pokemon.getId());
    }
}
