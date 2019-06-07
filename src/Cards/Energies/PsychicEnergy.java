package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;

public class PsychicEnergy extends AbstractCard implements IEnergy {
    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addPsychicEnergy();
        this.getTrainer().getHand().remove(this);
    }
}
