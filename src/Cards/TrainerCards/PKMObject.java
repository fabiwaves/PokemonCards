package Cards.TrainerCards;

import Cards.IPokemon;
import Controller.Game;
import Other.Effects.IEffect;

/**
 * @author fabiwave
 */

public class PKMObject extends TrainerCard {

    public IEffect effect;
    public IPokemon currentPokemon;

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
            this.currentPokemon = pokemon;
            t = true;
        }
        return t;
    }

    @Override
    public void notifyType(Game game) {
        game.playPKMObject(this);
    }
}
