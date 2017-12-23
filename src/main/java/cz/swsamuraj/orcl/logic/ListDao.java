package cz.swsamuraj.orcl.logic;

import java.util.Optional;

public interface ListDao {

    /**
     * Adds an element to the end of the list.
     *
     * @param element a node to be added
     */
    void push(String element);

    /**
     * Removes the last element from the list if it's
     * presented, otherwise optional
     *
     * @return a removed element
     */
    Optional<String> pop();

    /**
     * Inserts an element next to `after` element.
     *
     * @param element an element to be added
     * @param after an upcoming predecessor element
     */
    void insertAfter(String element, String after);

}
