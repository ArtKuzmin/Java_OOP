package Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class DefaultHero implements Behavior, Comparable<DefaultHero> {
    protected String name;
    protected int attack, defense, maxHealth, speed;
    protected int[] damage;
    protected double health;
    protected ArrayList<DefaultHero> side;
    boolean isDead;

    public Vector2 getPosition() {
        return position;
    }

    @Override
    public Vector2 findTarget(ArrayList<DefaultHero> party) {
        return new Vector2(1, 1);
    }


    protected Vector2 position;

    public DefaultHero(String name, int attack, int defense, int[] damage, int maxHealth,
                       int speed, ArrayList<DefaultHero> side, Vector2 position) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.speed = speed;
        this.side = side;
        this.position = position;
        this.isDead = false;
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
        return  String.format("%s\t%s\t ⚔ %d\t\uD83D\uDEE1 %d\t♥ %d/%d\t☠ %d\t⏭ %d\t\t",
                String.valueOf(getClass()).replace("class Units.", ""), name, attack, defense,(int) health, maxHealth, damage[0], speed);
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
