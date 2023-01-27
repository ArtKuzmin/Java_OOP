package Units;

import java.util.ArrayList;

public class Crossbowman extends RangedUnit {

    public Crossbowman(ArrayList<DefaultHero> side, int x, int y) {
        super(Names.randName(), 6, 3, new int[]{2, 3}, 10, 4, side, new Vector2(x, y), 16);

    }
}
