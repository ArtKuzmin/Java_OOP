package Units;

import java.util.ArrayList;

public abstract class RangedUnit extends DefaultHero implements Behavior {
    protected int shots;

    public RangedUnit(String name, int attack, int defense, int[] damage, int maxHealth,
                      int speed, ArrayList<DefaultHero> side, Vector2 position, int shots) {
        super(name, attack, defense, damage, maxHealth, speed, side, position);
        this.shots = shots;
    }

    @Override
    public String toString() {
        return super.toString() + ", shots = " + shots;
    }

    @Override
    public void step(ArrayList<DefaultHero> party) {
        boolean flag = false;
        if (shots > 0) {
            for (int i = 0; i < party.size(); i++) {
                if (party.get(i) instanceof Peasant) {
                    if (((Peasant) party.get(i)).supply) {
                        ((Peasant) party.get(i)).supply = false;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println(name + " fired! Ammo delivered by peasant");
            } else System.out.println(name + " fired! " + --shots + " shots remains");
        } else System.out.println("No ammo, can't shoot!");
    }
}
