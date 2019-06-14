package Cards.Energies;

import Cards.AbstractCard;
import Cards.ICard;
import Cards.IEnergy;
import Cards.IPokemon;

public class WaterEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play(ICard card) {
        IPokemon pokemon = (IPokemon) card;
        pokemon.addWaterEnergy();
        this.getTrainer().sendToGraveyard(this, getTrainer().getHand());
    }
}
