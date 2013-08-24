package data;

import java.util.concurrent.TimeUnit;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.Skills;
import org.powerbot.script.util.GeItem;

public class Achievements {

    private final long startTime = System.currentTimeMillis();
    private final int clayPrice;
    private long expGained;
    private MethodContext ctx;

    public Achievements(MethodContext ctx) {
        this.ctx = ctx;
        clayPrice = GeItem.getProfile(434)
                .getPrice(GeItem.PriceType.CURRENT).getPrice();

    }

    public String getTimeRan() {
        final long currentTime = System.currentTimeMillis() - startTime;
        String format = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(currentTime),
                TimeUnit.MILLISECONDS.toMinutes(currentTime)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(currentTime)),
                TimeUnit.MILLISECONDS.toSeconds(currentTime)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentTime)));
        return format;
    }

    public String getExpGained(long startExp) {
        expGained = ctx.skills.getExperience(Skills.MINING) - startExp;
        long timeRan = (System.currentTimeMillis() - startTime);
        int perHour = (int) ((expGained) * (3600000 / timeRan));
        return Long.toString(expGained) + "(" + perHour + ")";
    }

    public String getMoneyEarned() {
        int gained = clayPrice * (int) (expGained / 5);
        long timeRan = (System.currentTimeMillis() - startTime);
        int perHour = (int) ((gained) * (3600000 / timeRan));
        return Integer.toString(gained) + "(" + perHour + ")";
    }
}
