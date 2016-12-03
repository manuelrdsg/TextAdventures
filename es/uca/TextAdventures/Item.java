package es.uca.TextAdventures;

/**
 * es.uca.item.Item
 *
 * @author Manuel Rodríguez-Sánchez Guerra
 */

public abstract class Item {

    protected int id;

    public int getId() {
        return id;
    }

    public abstract int use();

}
