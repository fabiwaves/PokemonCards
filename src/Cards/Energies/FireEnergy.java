package Cards.Energies;

import Cards.AbstractCard;
import Controller.Game;

/**
 * @author fabiwave
 */

public class FireEnergy extends AbstractCard implements IEnergy {

    public void notifyType(Game game) {
        game.playFireEnergy(this);
    }
}
