package Abilities.Effects;

import Visitors.IVisitor;

/**
 * @author fabiwave
 */

public interface IEffect extends IVisitor {

    /**
     * Command to execute something before an action
     */
    void executeBefore();

    /**
     * Comand to execute something after an action
     */
    void executeAfter();

}
