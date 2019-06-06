package Cartas.TiposDeEnergias;

import Cartas.AbstractCard;
import Cartas.IEnergy;

public class LightingEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addLightningEnergy(this);
        this.getTrainer().getHand().remove(this);
    }
}
