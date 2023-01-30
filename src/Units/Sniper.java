package Units;

import java.util.ArrayList;

public class Sniper extends RangedUnit {

    public Sniper(ArrayList<DefaultHero> side, int x, int y) {
        super(Names.randName(), 12, 10, new int[]{8, 10}, 15, 9, side, new Vector2(x, y), 32);
    }

}
