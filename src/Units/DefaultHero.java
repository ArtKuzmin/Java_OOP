package Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class DefaultHero implements Behavior, Comparable<DefaultHero> {
    protected String name;
    protected int attack;
    protected int defense;
    protected int[] damage;
    protected int maxHealth;
    protected double health;
    protected int speed;
    protected ArrayList<DefaultHero> side;

    public Vector2 getPosition() {
        return position;
    }

    protected Vector2 position;

    public DefaultHero(String name, int attack, int defense, int[] damage, int maxHealth,
                       int speed, ArrayList<DefaultHero> side, Vector2 position) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth - new Random().nextInt(maxHealth);
        this.speed = speed;
        this.side = side;
        this.position = position;
    }

    @Override
    public String toString() {
        return String.valueOf(getClass()).replace("class Units.", "") +
                ", Name = '" + name + '\'' +
                ", attack = " + attack +
                ", defense = " + defense +
                ", damage = " + Arrays.toString(damage) +
                ", Max health = " + maxHealth +
                ", speed = " + speed;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public String getInfo() {
        return String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥ %.1f\t☠ %d\t⏭ %d\t\t",
                attack, defense, health, damage[0], speed);
    }

    @Override
    public void step(ArrayList<DefaultHero> party) {
        System.out.println("This unit does nothing so far");
    }

    @Override
    public int compareTo(DefaultHero o) {
        return this.maxHealth - o.maxHealth;
    }

    public String getName() {
        return String.valueOf(getClass()).replace("class Units.", "");
    }


}
