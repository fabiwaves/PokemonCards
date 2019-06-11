package Cards.Energies;

import Cards.AbstractCard;
import Cards.ICard;
import Cards.IEnergy;
import Cards.IPokemon;

public class LightingEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play(ICard card) {
        IPokemon pokemon = (IPokemon) card;
        pokemon.addLightningEnergy();
        this.getTrainer().sendToCementery(this, getTrainer().getHand());
    }
}
