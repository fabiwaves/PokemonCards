package Cartas.TiposDeEnergias;

import Cartas.AbstractCard;
import Cartas.IEnergy;

public class WaterEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addWaterEnergy(this);
        this.getTrainer().getHand().remove(this);
    }
}
