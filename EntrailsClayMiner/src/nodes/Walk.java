package nodes;

import data.Paths;
import data.PlayerActions;
import main.Node;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.TilePath;

public class Walk extends Node {

    private final Paths path = new Paths();

    public Walk(final MethodContext arg0) {
        super(arg0);

    }

    @Override
    public boolean validate() {
        return atBank() && !isBackpackFull()
                || atMiningSite() && isBackpackFull()
                || !atBank() && !atMiningSite();
    }

    @Override
    public void execute() {
        if (!isRunningFast()) {
            walk();
        }
    }

    private void walk() {
        TilePath tp = ctx.movement.newTilePath(path.getPath("draynor")).randomize(1, 2);
        if (!hasGoods()) {
            tp.traverse();
        } else {
            tp.reverse().traverse();
        }
    }
}
