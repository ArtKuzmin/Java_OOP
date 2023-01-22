package Units;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Healers extends DefaultHero implements Behavior {
    protected boolean mana = true;

    public Healers(String name, int attack, int defense, int[] damage, int health, int speed) {
        super(name, attack, defense, damage, health, speed);
    }

    @Override
    public String toString() {
        return super.toString() + ", mana = " + mana;
    }


    @Override
    public void step(ArrayList<DefaultHero> party) {
        List<DefaultHero> sortedParty = party.stream().sorted(Comparator.comparingInt(x ->
                (x.health * 100 / x.maxHealth))).toList();
        if (sortedParty.get(0).health == sortedParty.get(0).maxHealth)
            System.out.println("Nobody needs healing");
        else {
            if (sortedParty.get(0).health - damage[0] <= sortedParty.get(0).maxHealth) {
                sortedParty.get(0).health -= damage[0];
            } else sortedParty.get(0).health = sortedParty.get(0).maxHealth;
            System.out.println(String.valueOf(sortedParty.get(0).getClass()).replace("class Units.", "") +
                    " " + sortedParty.get(0).name + " is cured by " + name + ", health increased by " +
                    Math.abs(damage[0]) + " to " + sortedParty.get(0).health);
        }
    }
}

