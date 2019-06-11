package Cards.Energies;

import Cards.AbstractCard;
import Cards.ICard;
import Cards.IEnergy;
import Cards.IPokemon;

public class FireEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play(ICard card) {
        IPokemon pokemon = (IPokemon) card;
        pokemon.addFireEnergy();
        this.getTrainer().sendToCementery(this, getTrainer().getHand());
    }
}
