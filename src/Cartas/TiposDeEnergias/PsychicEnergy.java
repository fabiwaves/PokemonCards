package Cartas.TiposDeEnergias;

import Cartas.AbstractCard;
import Cartas.IEnergy;

public class PsychicEnergy extends AbstractCard implements IEnergy {
    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addPsychicEnergy(this);
        this.getTrainer().getHand().remove(this);
    }
}
