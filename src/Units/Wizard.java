package Units;

import java.util.ArrayList;

public class Wizard extends Healers {

    public Wizard(ArrayList<DefaultHero> side, int x, int y) {
        super(Names.randName(), 17, 12, new int[]{-5}, 30, 9, side, new Vector2(x, y));
    }
}
