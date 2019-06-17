package Visitors;

import Cards.IPokemon;
import Players.Trainer;

/**
 * @author fabiwave
 */

public interface IVisitor {

    /**
     * Visitor of a pokemon
     *
     * @param pokemon object that I want to visit
     */
    void visitPokemon(IPokemon pokemon);

    /**
     * Visitor of a trainer
     *
     * @param trainer object that I want to visit
     */
    void visitTrainer(Trainer trainer);

}
