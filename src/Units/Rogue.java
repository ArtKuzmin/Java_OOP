package Units;

import java.util.ArrayList;

public class Rogue extends CloseRangeUnit {

    public Rogue(ArrayList<DefaultHero> side, int x, int y) {
        super(Names.randName(), 8, 3, new int[]{2, 4}, 16, 10, side, new Vector2(x, y));
    }
    @Override
    public String getInfo() {
        return String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥ %.1f\t☠ %d\t⏭%d\t",
                attack, defense, health, damage[0], speed);
    }

}
