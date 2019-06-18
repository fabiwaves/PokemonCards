package Cards.TrainerCards;

import Abilities.Effects.IEffect;
import Cards.IPokemon;
import Controller.Game;

/**
 * @author fabiwave
 */

public class PKMObject extends TrainerCard {

    public IEffect effect;
    private IPokemon current_pokemon;

    public PKMObject(IEffect effect) {
        this.effect = effect;
    }

    /**
     * Sets the current pokemon who will have this object associated
     *
     * @param pokemon that will have the object
     * @return True if it works, false otherwise
     */
    public boolean setCurrentPokemon(IPokemon pokemon) {
        boolean t = false;
        if (pokemon.getPKMObject() == null) {
            this.current_pokemon = pokemon;
            t = true;
        }
        return t;
    }

    IPokemon getCurrentPokemon() {
        return this.current_pokemon;
    }

    @Override
    public void notifyType(Game game) {
        game.playPKMObject(this);
    }
}
