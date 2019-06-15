package Cards.Phases;

import Cards.IPokemon;

public class Phase1 extends AbstractPhase{

    public Phase1(int prev1){
        this.setPrev_pokemon_id1(prev1);
        this.setPrev_pokemon_id2(-1);
    }

    /**
     * Checks if a pokemon is the pre-evolution of this phase by the id
     * @param pokemon that wants to be checkes
     * @return true if it is the pokemon, false otherwise
     */
    @Override
    public boolean checkPrevId1(IPokemon pokemon){
        return (this.prev_pokemon_id1 == pokemon.getId());
    }

}
