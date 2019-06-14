package Cards.Energies;

import Cards.AbstractCard;
import Cards.ICard;
import Cards.IEnergy;
import Cards.IPokemon;

public class PlantEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play(ICard card) {
        IPokemon pokemon = (IPokemon) card;
        pokemon.addPlantEnergy();
        this.getTrainer().sendToGraveyard(this, getTrainer().getHand());

    }
}
