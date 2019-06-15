package Cards.TrainerCards;

import Controller.Game;
import Other.Effects.IEffect;

public class Stadium extends TrainerCard {

    private IEffect effect;

    public Stadium(IEffect effect){
        this.effect = effect;
    }

    @Override
    public void play() {
        this.effect.executeBefore();
        this.effect.executeAfter();
    }

    @Override
    public void notifyType(Game game) {
        game.playStadium(this);
    }
}
