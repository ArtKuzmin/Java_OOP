package Units;

import java.util.ArrayList;

public abstract class CloseRangeUnit extends DefaultHero implements Behavior {

    public CloseRangeUnit(String name, int attack, int defense, int[] damage, int maxHealth,
                          int speed, ArrayList<DefaultHero> side, Vector2 position) {
        super(name, attack, defense, damage, maxHealth, speed, side, position);
    }


    public Vector2 findTarget(ArrayList<DefaultHero> party) {
        float minDistance = (float) (party.size() * 1.5);
        float index = -1;
        for (int i = 0; i < party.size(); i++) {
            if (!party.get(i).isDead && getPosition().getDistance(party.get(i)) < minDistance) {
                minDistance = getPosition().getDistance(party.get(i));
                index = i;
            }
        }
        return new Vector2(minDistance, index);
    }

    int calcDamage(DefaultHero hero) {
        int dealtDamage;
        if (attack > hero.defense)
            dealtDamage = damage[1];
        else dealtDamage = damage[0];
        return dealtDamage;
    }

    protected boolean checkPosition(Vector2 position) {
        for (DefaultHero npc : this.side) {
            if (npc.getPosition().isEquals(position))
                return false;
        }
        return true;
    }

    public void takeStep(DefaultHero hero) {
        int x = (int) getPosition().x;
        int y = (int) getPosition().y;
        if (hero.position.x > x && checkPosition(new Vector2(++x, y))) {
            position.x = x;
        } else if (hero.position.x < x && checkPosition(new Vector2(--x, y))) {
            position.x = x;
        } else if (hero.position.y > y && checkPosition(new Vector2(x, ++y))) {
            position.y = y;
        } else if (hero.position.y < y && checkPosition(new Vector2(x, --y))) {
            position.y = y;
        }
    }

    @Override
    public void step(ArrayList<DefaultHero> party) {
        if (isDead) System.out.println("Unit is dead");
        else {
            Vector2 target = findTarget(party);
            int targetIndex = (int) target.y;//
            int hit = calcDamage(party.get(targetIndex));
            if (target.x > 1) {
                takeStep(party.get(targetIndex));
                System.out.println(getName() + " " + name + " moved.");
            } else {
                if (party.get(targetIndex).health > hit) {
                    party.get(targetIndex).health = party.get(targetIndex).health - hit;
                    System.out.println(getName() + " " + name + " stroke " + party.get(targetIndex).getName() +
                            " " + party.get(targetIndex).name + " and inflict " + hit + " damage!");
                } else {
                    party.get(targetIndex).health = 0;
                    party.get(targetIndex).isDead = true;
                    System.out.println(getName() + " " + name + " killed " + party.get(targetIndex).getName());
                }
            }
        }
    }
}
