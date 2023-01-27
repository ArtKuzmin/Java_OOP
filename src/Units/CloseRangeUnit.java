package Units;

import java.util.ArrayList;

public abstract class CloseRangeUnit extends DefaultHero implements Behavior {

    public CloseRangeUnit(String name, int attack, int defense, int[] damage, int maxHealth,
                          int speed, ArrayList<DefaultHero> side, Vector2 position) {
        super(name, attack, defense, damage, maxHealth, speed, side, position);
    }
}
