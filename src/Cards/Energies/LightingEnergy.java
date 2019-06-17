package Cards.Energies;

import Cards.AbstractCard;
import Controller.Game;

/**
 * @author fabiwave
 */

public class LightingEnergy extends AbstractCard implements IEnergy {

    public void notifyType(Game game) {
        game.playLightingEnergy(this);
    }
}
