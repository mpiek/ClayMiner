package main;

import data.Achievements;
import data.PaintUtilities;
import java.awt.Graphics;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.util.Random;

import java.util.ArrayList;
import java.util.Collections;
import nodes.*;
import org.powerbot.event.PaintListener;
import org.powerbot.script.methods.Bank;
import org.powerbot.script.methods.Skills;

@Manifest(authors = {"Algathonix"}, name = "Clay Miner", description = "Mines Clay NW-Draynor + Bank")
public class ClayMiner extends PollingScript implements PaintListener {

    private final PaintUtilities paintUtil = new PaintUtilities();
    private long startExp;
    private String accountName;
    private final Achievements Achievements = new Achievements(ctx);
    private final ArrayList<Node> nodes = new ArrayList<>();

    public ClayMiner() {
        Collections.addAll(nodes, new Mine(ctx), new nodes.Bank(ctx),
                new Walk(ctx));
    }

    @Override
    public void start() {
        startExp = ctx.skills.getExperience(Skills.MINING);
        accountName = this.ctx.players.local().getName();
    }

    @Override
    public int poll() {
        for (final Node node : nodes) {
            if (node.validate()) {
                node.execute();
                return Random.nextInt(250, 500);
            }
        }
        return 0;
    }

    @Override
    public void repaint(Graphics g) {
        g.drawImage(paintUtil.getImage(), 0, 400, null);
        g.drawString(Achievements.getTimeRan(), 110, 468);
        g.drawString(Achievements.getMoneyEarned(), 110, 495);
        g.drawString(Achievements.getExpGained(startExp), 110, 526);
        g.drawString(accountName, 110, 555);
    }
}