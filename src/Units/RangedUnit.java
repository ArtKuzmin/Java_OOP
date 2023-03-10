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


    public Vector2 findTarget(ArrayList<DefaultHero> party) {
        float minDistance = (float) (party.size() * 1.5);
        float index = -1;
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
        for (DefaultHero defaultHero : side) {
            if (defaultHero.getName().equals("Peasant")) {
                if (((Peasant) defaultHero).supply) {
                    ((Peasant) defaultHero).supply = false;
                    flag = true;
                    break;
                }
            }
        }
        return flag;
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

    @Override
    public void step(ArrayList<DefaultHero> party) {
        Vector2 target = findTarget(party);
        if (isDead) System.out.println(getName() + " " + name + " is dead");
        else if (target.y == -1)
            System.out.println("Everyone is dead");
        else {
            boolean flag = checkForPeasant();
            int targetIndex = (int) target.y;
            int hit = (int) calcDamage(target, party.get(targetIndex));
            if (shots > 0) {
                if (party.get(targetIndex).health > hit)
                    party.get(targetIndex).health = party.get(targetIndex).health - hit;
                else {
                    party.get(targetIndex).health = 0;
                    party.get(targetIndex).isDead = true;
                }
                if (flag) {
                    System.out.println(getName() + " " + name + " fired at " +
                            party.get(targetIndex).getName() + " " + party.get(targetIndex).name +
                            " and inflict " + hit + " damage! Ammo delivered by peasant");
                } else
                    System.out.println(getName() + " " + name + " fired at " + party.get(targetIndex).name +
                            " and inflict " + hit + " damage! " + --shots + " shots remains");
            } else
                System.out.println("No ammo, can't shoot!");
        }
    }
}
