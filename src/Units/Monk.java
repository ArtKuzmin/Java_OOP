package Units;

import java.util.ArrayList;

public class Monk extends Healers {
    public Monk(ArrayList<DefaultHero> side, int x, int y) {
        super(Names.randName(), 12, 7, new int[]{-4}, 30, 5, side, new Vector2(x, y));
    }
}
