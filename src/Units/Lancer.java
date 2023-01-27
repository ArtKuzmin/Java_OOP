package Units;

import java.util.ArrayList;

public class Lancer extends CloseRangeUnit {

    public Lancer(ArrayList<DefaultHero> side, int x, int y) {
        super(Names.randName(), 4, 5, new int[]{1, 3}, 10, 4, side, new Vector2(x, y));
    }
}
