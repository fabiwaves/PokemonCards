package Cards.Energies;

import Cards.AbstractCard;
import Cards.IEnergy;
import Controller.Game;

public class FightingEnergy extends AbstractCard implements IEnergy {

    public void notifyType(Game game) {
        game.playFightingEnergy(this);
    }
}
