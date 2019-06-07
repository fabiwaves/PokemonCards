package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;

public class FireEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addFireEnergy();
        this.getTrainer().getHand().remove(this);
    }
}
