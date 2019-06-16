package Cards.Phases;

import Cards.IPokemon;

/**
 * @author fabiwave
 */

public abstract class AbstractPhase implements IPhase {

    protected int prev_pokemon_id1;
    protected int prev_pokemon_id2;

    public int getPrev_pokemon_id() {
        return prev_pokemon_id1;
    }

    public int getPrev_pokemon_id2() {
        return prev_pokemon_id2;
    }

    public void setPrev_pokemon_id2(int prev_pokemon_id2) {
        this.prev_pokemon_id2 = prev_pokemon_id2;
    }

    public void setPrev_pokemon_id1(int prev_pokemon_id1) {
        this.prev_pokemon_id1 = prev_pokemon_id1;
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
