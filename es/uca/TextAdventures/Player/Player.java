package es.uca.TextAdventures.Player;

import es.uca.TextAdventures.Item.Item;
import es.uca.TextAdventures.Item.WeaponItem;
import es.uca.TextAdventures.Item.ArmorItem;

import java.util.Set;

/**
 * es.uca.playerCharacter.TextAdventures.Player
 *
 * @author Manuel Rodríguez-Sánchez Guerra
 */

public abstract class Player {

    static final double DAMAGE_TABLE[][] = {
            {1, 2, 0.5, 1, 0.5},
            {0.5, 1, 2, 1, 0.5},
            {2, 0.5, 1, 2, 0.5},
            {0.5, 2, 0.5, 1, 0.5},
            {2, 2, 2, 2, 1}
    };
    protected String name;
    protected int id;
    protected double healthPoints;
    protected Set<Item> inventory;
    protected int baseDamage;

    public Player(String name, int id, double healthPoints, Set<Item> inventory, int baseDamage) {
        this.name = name;
        this.id = id;
        this.healthPoints = healthPoints;
        this.inventory = inventory;
        this.baseDamage = baseDamage;
    }


    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getId() {
        return id;
    }

    public Set<Item> getInventory() {
        return inventory;
    }

    public void setInventory(Set<Item> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public abstract boolean usePotion();

    public boolean hasWeapon() {

        return (inventory.stream().anyMatch((i) -> i instanceof WeaponItem));
    }

    public boolean hasArmor() {
        return (inventory.stream().anyMatch((i) -> i instanceof ArmorItem));
    }

    public abstract boolean attack(Player otherCharacter);
}
