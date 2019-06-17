package Cards.Phases;

import Cards.IPokemon;

/**
 * @author fabiwave
 */

public abstract class AbstractPhase implements IPhase {

    int prev_pokemon_id1;
    int prev_pokemon_id2;

    public int getPrev_pokemon_id() {
        return prev_pokemon_id1;
    }

    public int getPrev_pokemon_id2() {
        return prev_pokemon_id2;
    }

    @Override
    public boolean checkPrevId1(IPokemon pokemon) {
        return false;
    }

    @Override
    public boolean checkPrevId2(IPokemon pokemon) {
        return false;
    }
}
