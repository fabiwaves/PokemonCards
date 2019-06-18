package Cards.Energies;

import Cards.AbstractCard;
import Controller.Game;

/**
 * @author fabiwave
 */

public class LightningEnergy extends AbstractCard implements IEnergy {

    public LightningEnergy() {
        this.setName("Lightning Energy");
    }

    public void notifyType(Game game) {
        game.playLightningEnergy(this);
    }
}
