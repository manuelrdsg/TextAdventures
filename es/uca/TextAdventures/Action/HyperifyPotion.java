package es.uca.TextAdventures.Action;

import es.uca.TextAdventures.Item.Item;
import es.uca.TextAdventures.Item.RecoveryItemDecorator.HyperRecoveryItem;
import es.uca.TextAdventures.Item.RecoveryItemDecorator.RecoveryItem;
import es.uca.TextAdventures.Item.RecoveryItemDecorator.SimpleRecoveryItem;
import es.uca.TextAdventures.Item.RecoveryItemDecorator.SuperRecoveryItem;
import es.uca.TextAdventures.Player.Player;

/**
 * Created by juan on 30/01/17.
 */
public class HyperifyPotion extends InventoryAction {

    public HyperifyPotion(String description, Player player) {
        super(description, player);
    }

    public void run(ActionParameter actionParameter, Item potionToHyperify) {

        if (actionParameter.getPlayerCharacter().getInventory().size() > 2 && (potionToHyperify instanceof SimpleRecoveryItem
                || potionToHyperify instanceof SuperRecoveryItem)) {
            actionParameter.getOutput().showMessage("In order to hyperify a potion, you need to sacrifice two items ;) ");
            int itemsCount = 0;
            do {
                actionParameter.getOutput().showInventory();
                int itemSelected = actionParameter.getInput().getInput();
                if (itemSelected != 0) {
                    Item itemToSacrifice = (Item) actionParameter.getPlayerCharacter().getInventory().toArray()[itemSelected - 1];
                    if (itemToSacrifice != potionToHyperify)
                        actionParameter.getPlayerCharacter().getInventory().remove(itemToSacrifice);
                    else
                        actionParameter.getOutput().showMessage("You can't sacrifice the same item that you want to superify. Don't be clever!. Now you lost your turn :)");
                }
                itemsCount++;
            } while (itemsCount < 2);

            actionParameter.getOutput().showMessage("Ok!, lets hyperify that potion...");

            HyperRecoveryItem hyperPotion = new HyperRecoveryItem((RecoveryItem) potionToHyperify);
            actionParameter.getPlayerCharacter().getInventory().remove(potionToHyperify);
            actionParameter.getPlayerCharacter().getInventory().add(hyperPotion);

        } else
            actionParameter.getOutput().showMessage("You can't hyperify a potion if you don't have enough items to sacrifice! or if that potion it's hyperified yet! :(");
    }
}
