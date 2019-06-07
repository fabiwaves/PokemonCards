package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;

public class PlantEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addPlantEnergy();
        this.getTrainer().getHand().remove(this);

    }
}
