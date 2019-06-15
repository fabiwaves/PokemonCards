package Cards.TrainerCards;

import Cards.IPokemon;
import Controller.Game;
import Other.Effects.IEffect;

public class PKMObject extends TrainerCard {

    private IEffect effect;
    private IPokemon currentPokemon;

    public PKMObject(IEffect effect) {
        this.effect = effect;
    }

    public boolean setCurrentPokemon(IPokemon pokemon) {
        boolean t = false;
        if (pokemon.getPKMObject() == null) {
            this.currentPokemon = pokemon;
            t = true;
        }
        return t;
    }

    @Override
    public void play() {
        if(setCurrentPokemon(this.getTrainer().selectOwnPokemonTarget())) {
            this.effect.executeBefore();
            this.effect.executeAfter();}
    }

    @Override
    public void notifyType(Game game) {
        game.playPKMObject(this);
    }
}
