package Units;

import java.util.ArrayList;

public class Peasant extends DefaultHero {

    protected boolean supply = true;

    public void setSupply(boolean supply) {
        this.supply = supply;
    }

    public Peasant(String name, int attack, int defense, int[] damage, int health, int speed) {
        super(name, attack, defense, damage, health, speed);
    }

    public Peasant(String name) {
        super(name, 1, 1, new int[]{1}, 1, 3);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + ", supply = " + supply;
    }

    @Override
    public void step(ArrayList<DefaultHero> party) {
        this.supply = true;
        System.out.println("Peasant rested and ready to supply");
    }
}
