package Cartas.TiposDeEnergias;

import Cartas.AbstractCard;
import Cartas.IEnergy;

public class FireEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addFireEnergy(this);
        this.getTrainer().getHand().remove(this);
    }
}
