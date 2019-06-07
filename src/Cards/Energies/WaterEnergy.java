package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;

public class WaterEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addWaterEnergy();
        this.getTrainer().getHand().remove(this);
    }
}
