package Cards.Energies;

import Cards.AbstractCard;
import Controller.Game;

/**
 * @author fabiwave
 */

public class FightingEnergy extends AbstractCard implements IEnergy {

    public void notifyType(Game game) {
        game.playFightingEnergy(this);
    }
}
