package Units;

import java.util.ArrayList;

public abstract class CloseRangeUnit extends DefaultHero implements Behavior {

    public CloseRangeUnit(String name, int attack, int defense, int[] damage, int maxHealth,
                          int speed, ArrayList<DefaultHero> side, Vector2 position) {
        super(name, attack, defense, damage, maxHealth, speed, side, position);
    }

    @Override
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
        if (isDead) System.out.println("Unit is dead");
        else {
            Vector2 target = findTarget(party);
            int targetIndex = (int) target.y;
            int hit = (int) calcDamage(target, party.get(targetIndex));
            if (target.x < 2) {
                calcDamage(target, party.get((int) target.y));
                if (party.get(targetIndex).health > hit)
                    party.get(targetIndex).health = party.get(targetIndex).health - hit;
                else {
                    party.get(targetIndex).health = 0;
                    party.get(targetIndex).isDead = true;
                }
            }
            else{

            }

        }
    }

}
