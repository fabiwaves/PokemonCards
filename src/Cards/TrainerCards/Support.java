package Cards.TrainerCards;

import Controller.Game;
import Other.Effects.IEffect;

public class Support extends TrainerCard {

    private IEffect effect;

    public Support(IEffect effect){
        this.effect = effect;
    }

    @Override
    public void play() {
        this.effect.executeBefore();
        this.effect.executeAfter();
    }

    @Override
    public void notifyType(Game game) {
        game.playSupport(this);

    }
}
