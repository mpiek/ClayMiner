package data;

import org.powerbot.script.wrappers.Tile;

public class Paths {

    private final Tile[] DRAYNOR = new Tile[]{new Tile(3094, 3244, 0), new Tile(3094, 3249, 0), new Tile(3099, 3250, 0),
        new Tile(3104, 3253, 0), new Tile(3105, 3258, 0), new Tile(3105, 3263, 0),
        new Tile(3105, 3268, 0), new Tile(3105, 3273, 0), new Tile(3106, 3278, 0),
        new Tile(3109, 3282, 0), new Tile(3110, 3287, 0), new Tile(3110, 3293, 0),
        new Tile(3109, 3298, 0), new Tile(3113, 3302, 0), new Tile(3117, 3304, 0),
        new Tile(3122, 3307, 0), new Tile(3127, 3309, 0), new Tile(3131, 3310, 0),
        new Tile(3136, 3313, 0), new Tile(3140, 3315, 0), new Tile(3142, 3318, 0)};

    public Tile[] getPath(String location) {
        switch (location) {
            case ("draynor"):
                return DRAYNOR;
        }
        return null;
    }
}
