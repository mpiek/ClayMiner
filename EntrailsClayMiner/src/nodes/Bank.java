package nodes;

import data.Locations;
import data.PlayerActions;
import main.Node;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;

/**
 *
 * @author Matthijs
 */
public class Bank extends Node {

   private final Locations AREA = new Locations();
   private PlayerActions pa = null;

    public Bank(final MethodContext arg0) {
        super(arg0);
        pa = new PlayerActions(arg0);
    }

    @Override
    public boolean validate() {
        return pa.atBank()
                && pa.hasGoods();
    }

    @Override
    public void execute() {
        bankItems();
    }

   @Override
    public void bankItems() {
        if (ctx.bank.isOpen()) {
            pa.bankItems();
            ctx.bank.close();
        } else {
            ctx.bank.open();
        }

    }
}
