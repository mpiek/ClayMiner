package nodes;

import data.Locations;
import data.PlayerActions;
import main.Node;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.GameObject;

public class Mine extends Node {

    private final Locations AREA = new Locations();
    private final int[] CLAYROCKS = {10579, 10578, 10577};
    private PlayerActions pa = null;
    private GameObject rock;

    public Mine(final MethodContext arg0) {
        super(arg0);
        pa = new PlayerActions(arg0);

    }

    @Override
    public void execute() {
        mineRock();
    }

    @Override
    public boolean validate() {
        return !pa.isBackpackFull()
                && pa.atMiningSite() && !pa.isInteracting();
    }

    private void mineRock() {
        rock = getNearest();
        if (rock != null) {
            rock.interact("Mine");
        }
        sleep(1500, 2000); // debounce
        while (pa.miningStance()) {
        }

    }

    private GameObject getNearest() {
        for (final GameObject rock : ctx.objects.id(CLAYROCKS)
                .nearest().first()) {
            if (rock != ctx.objects.getNil()) {
                return rock;
            }
        }
        return null;
    }
}
