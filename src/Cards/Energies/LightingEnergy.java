package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;

public class LightingEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addLightningEnergy();
        this.getTrainer().getHand().remove(this);
    }
}
