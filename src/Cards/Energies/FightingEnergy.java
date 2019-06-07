package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;

public class FightingEnergy extends AbstractCard implements IEnergy {

    @Override
    public void play() {
        this.getTrainer().getActivePokemon().addFightingEnergy();
        this.getTrainer().getHand().remove(this);
    }
}
