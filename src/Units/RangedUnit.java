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
    public Vector2 findTarget(ArrayList<DefaultHero> party) {
        float minDistance = 15;
        float index = 0;
        for (int i = 0; i < party.size(); i++) {
            if (getPosition().getDistance(party.get(i)) < minDistance && !party.get(i).isDead) {
                minDistance = getPosition().getDistance(party.get(i));
                index = i;
            }
        }
        return new Vector2(minDistance, index);
    }

    boolean checkForPeasant() {
        boolean flag = false;
        for (int i = 0; i < side.size(); i++) {
            if (side.get(i) instanceof Peasant) {
                if (((Peasant) side.get(i)).supply) {
                    ((Peasant) side.get(i)).supply = false;
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public void step(ArrayList<DefaultHero> party) {
        if (isDead) return;
        else {
            boolean flag = checkForPeasant();
            Vector2 target = findTarget(party);
            int targetIndex = (int) target.y;
            if (shots > 0) {
                if (party.get(targetIndex).health > calcDamage(target, party.get(targetIndex)))
                    party.get(targetIndex).health = party.get(targetIndex).health - calcDamage(target, party.get(targetIndex));
                else {
                    party.get(targetIndex).health = 0;
                    party.get(targetIndex).isDead = true;
                }
                if (flag) {
                    System.out.println(name + " fired at " + party.get(targetIndex).name + " and inflict " + (int) calcDamage(target, party.get(targetIndex)) + " damage! Ammo delivered by peasant");
                } else
                    System.out.println(name + " fired at " + party.get(targetIndex).name + " and inflict " + (int) calcDamage(target, party.get(targetIndex)) + " damage! " + --shots + " shots remains");
            } else System.out.println("No ammo, can't shoot!");
        }
    }

    float calcDamage(Vector2 target, DefaultHero hero) {
        float dealtDamage;
        if (target.x < side.size() * 0.4)
            dealtDamage = damage[1];
        else if (attack > hero.defense && target.x < side.size() * 0.4)
            dealtDamage = (float) (damage[0] + damage[1]) / 2;
        else dealtDamage = damage[0];
        return dealtDamage;
    }
}
