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
//    @Override
//    public int findTarget(ArrayList<DefaultHero> party){
//        int index = 0;
//        List<DefaultHero> sortedParty = party.stream().sorted(Comparator.comparingDouble(x ->
//                (x.health * 100 / x.maxHealth))).toList();
//        return index;
//    }

    @Override
    public void step(ArrayList<DefaultHero> party) {
        List<DefaultHero> sortedParty = side.stream().sorted(Comparator.comparingDouble(x ->
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
//    @Override
//    public String getInfo() {
//        return String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥ %.1f/%d\t☠%d\t⏭ %d\t\t", attack, defense, health, maxHealth, damage[0], speed);
//    }
}

