package Units;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Healers extends DefaultHero implements Behavior {
    protected boolean mana;

    public Healers(String name, int attack, int defense, int[] damage, int maxHealth,
                   int speed, ArrayList<DefaultHero> side, Vector2 position) {
        super(name, attack, defense, damage, maxHealth, speed, side, position);
        this.mana = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", mana = " + mana;
    }

    @Override
    public void step(ArrayList<DefaultHero> party) {
        if (isDead) System.out.println("Unit is dead");
        else {
            List<DefaultHero> sortedParty = new ArrayList<>();
            for (DefaultHero h : side) {
                if (!h.isDead)
                    sortedParty.add(h);
            }
            sortedParty.sort(Comparator.comparingDouble(x -> (x.health * 100 / x.maxHealth)));

            if (sortedParty.get(0).health == sortedParty.get(0).maxHealth)
                System.out.println("Nobody needs healing");
            else {
                if (sortedParty.get(0).health - damage[0] <= sortedParty.get(0).maxHealth) {
                    sortedParty.get(0).health -= damage[0];
                } else sortedParty.get(0).health = sortedParty.get(0).maxHealth;
                System.out.println(sortedParty.get(0).getName() +
                        " " + sortedParty.get(0).name + " is cured by " + getName() + " " +name + ", health increased by " +
                        Math.abs(damage[0]) + " to " + sortedParty.get(0).health);
            }
        }
    }
}

