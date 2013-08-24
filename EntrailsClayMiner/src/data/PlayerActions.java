package data;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;

public class PlayerActions {

    private final int goods[] = {1617, 1623, 1621, 1620, 434};
    private MethodContext ctx;
    private final Locations AREA = new Locations();

    public PlayerActions(MethodContext ctx) {
        this.ctx = ctx;
    }

    public boolean miningStance() {
        return ctx.players.local().getAnimation()== 625
            ;
    }
    
    public boolean isBackpackFull() {
        return ctx.backpack.select().count() >= 28;
    }

    public boolean isInteracting() {
        return ctx.players.local().getAnimation() != -1
                || ctx.players.local().isInMotion();
    }

    public boolean isRunningFast() {
        return ctx.players.local().isInMotion();
    }

    public boolean atBank() {
        return AREA.getLocation("bank").
                contains(ctx.players.local().getLocation());
    }

    public boolean atMiningSite() {
        return AREA.getLocation("mining").
                contains(ctx.players.local().getLocation());
    }

    public boolean hasGoods() {
        for (final Item item : ctx.backpack.getAllItems()) {
            for(int id : goods)
            if (item.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    public void bankItems(){
          for (final Item item : ctx.backpack.getAllItems()) {
            for(int id : goods)
            if (item.getId() == id) {
                ctx.bank.deposit(id,
                        org.powerbot.script.methods.Bank.Amount.ALL);
            }
        }
     
    }
}
