package Units;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public abstract class Healers extends DefaultHero implements Behavior {
    protected boolean mana;
    protected boolean ableToAct;

    public Healers(String name, int attack, int defense, int[] damage, int maxHealth,
                   int speed, ArrayList<DefaultHero> side, Vector2 position) {
        super(name, attack, defense, damage, maxHealth, speed, side, position);
        this.mana = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", mana = " + mana;
    }

    void heal() {
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
                    " " + sortedParty.get(0).name + " is cured by " + getName() + " " + name + ", health increased by " +
                    Math.abs(damage[0]) + " to " + sortedParty.get(0).health);
        }
    }

    void revive(int personToRevive) {
        String s = side.get(personToRevive).getName() + " " + side.get(personToRevive).name;
        DefaultHero revivedHero = reviveHero(side.get(personToRevive).position);
        side.set(personToRevive, revivedHero);
        System.out.println(getName() + " " + name + "  revived " + s +
                " into " + side.get(personToRevive).getName() + " " + side.get(personToRevive).name);
    }

    DefaultHero reviveHero(Vector2 v) {
        Random random = new Random();
        float x = v.x;
        float y = v.y;
        DefaultHero revivedHero = new Peasant(side, (int) x++, (int) y);
        for (int i = 0; i < side.size(); i++) {
            int value = random.nextInt(4);
            if (this.getName().equals("Wizard") || this.getName().equals("Rogue") || this.getName().equals("Sniper")) {
                switch (value) {
                    case 0 -> revivedHero = new Peasant(side, (int) x, (int) y);
                    case 1 -> revivedHero = new Rogue(side, (int) x, (int) y);
                    case 2 -> revivedHero = new Sniper(side, (int) x, (int) y);
                    case 3 -> revivedHero = new Wizard(side, (int) x, (int) y);
                }
            } else {
                switch (value) {
                    case 0 -> revivedHero = new Monk(side, (int) x, (int) y);
                    case 1 -> revivedHero = new Peasant(side, (int) x, (int) y);
                    case 2 -> revivedHero = new Lancer(side, (int) x, (int) y);
                    case 3 -> revivedHero = new Crossbowman(side, (int) x, (int) y);
                }
            }
        }
        return revivedHero;
    }

    @Override
    public void step(ArrayList<DefaultHero> party) {
        if (isDead) System.out.println(getName() + " " + name + " is dead");
        else {
            if (!ableToAct) {
                ableToAct = true;
                System.out.println(getName() + " " + name + " is resting after resurrection");
            } else {
                int personToRevive = -1;
                for (int i = 0; i < side.size(); i++) {
                    if (side.get(i).isDead) {
                        personToRevive = i;
                        break;
                    }
                }
                if (personToRevive >= 0) {
                    revive(personToRevive);
                    side.sort(Comparator.comparingInt(a -> a.speed));
                    ableToAct = false;
                } else heal();
            }
        }
    }
}

