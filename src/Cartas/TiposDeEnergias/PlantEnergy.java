package Cartas.TiposDeEnergias;

import Cartas.AbstractCard;
import Cartas.IEnergy;

public class PlantEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addPlantEnergy(this);
        this.getTrainer().getHand().remove(this);

    }
}
