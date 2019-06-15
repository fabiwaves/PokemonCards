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

    private void setCurrentPokemon(IPokemon pokemon) {
        if (pokemon.getPKMObject() == null) {
            this.currentPokemon = pokemon;
        }
    }

    @Override
    public void play() {
        setCurrentPokemon(this.getTrainer().selectOwnPokemonTarget());
        // TODO: Revisar bien
        this.effect.executeBefore();
        this.effect.executeAfter();
    }

    @Override
    public void notifyType(Game game) {
        // TODO: Implement
    }
}
