package Cartas.TiposDeEnergias;

import Cartas.AbstractCard;
import Cartas.IEnergy;

public class FightingEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addFightingEnergy(this);
        this.getTrainer().getHand().remove(this);
    }
}
