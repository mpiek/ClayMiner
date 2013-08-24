package main;

import data.PlayerActions;
import org.powerbot.script.methods.MethodContext;

public abstract class Node extends PlayerActions {

    public Node(final MethodContext arg0) {
        super(arg0);
    }

    public abstract boolean validate();

    public abstract void execute();
}