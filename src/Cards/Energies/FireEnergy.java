package Cards.Energies;

import Cards.AbstractCard;
import Controller.Game;

/**
 * @author fabiwave
 */

public class FireEnergy extends AbstractCard implements IEnergy {

    public FireEnergy(){
        this.setName("Fire Energy");
    }

    public void notifyType(Game game) {
        game.playFireEnergy(this);
    }
}
