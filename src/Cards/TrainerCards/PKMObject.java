package Cards.TrainerCards;

import Cards.ICard;
import Cards.IPokemon;
import Other.Effect;

public class PKMObject extends TrainerCard {

    private Effect effect;
    private IPokemon currentPokemon;

    public PKMObject(Effect effect) {
        this.effect = effect;
    }

    public void setCurrentPokemon(IPokemon pokemon) {
        if (pokemon.getPKMObject() == null) {
            this.currentPokemon = pokemon;
        }
    }

    @Override
    public void play(ICard card) {
        this.setCurrentPokemon((IPokemon) card);
        if (currentPokemon != null) {
            this.effect.execute();
        }
    }
}
