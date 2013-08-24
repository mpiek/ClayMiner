package data;

import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.Tile;

public class Locations {

    private final Area BANKING_AREA =
            new Area(new Tile(3092, 3242, 0), new Tile(3096, 3246, 0));
    private final Area MINING_AREA =
            new Area(new Tile(3137, 3320, 0), new Tile(3144, 3315, 0));

    /**
     *
     * @param location use bank or mining for now
     * @return the specified area
     */
    public Area getLocation(String location) {
        switch (location) {
            case ("bank"):
                return BANKING_AREA;
            case ("mining"):
                return MINING_AREA;

        }
        return null;
    }
}
