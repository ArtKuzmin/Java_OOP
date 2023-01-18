import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class DefaultHero implements HealAndInfo {
    private String name;
    private int attack;
    private int defense;
    private int[] damage;
    private int maxHealth;
    private int health;
    private int speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int[] getDamage() {
        return damage;
    }

    public void setDamage(int[] damage) {
        this.damage = damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public DefaultHero(String name, int attack, int defense, int[] damage, int maxHealth, int speed) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.speed = speed;
        this.health = maxHealth - new Random().nextInt(maxHealth);
    }

    @Override
    public String toString() {
        return getClass() +
                ", Name = '" + name + '\'' +
                ", attack = " + attack +
                ", defense = " + defense +
                ", damage = " + Arrays.toString(damage) +
                ", Max health = " + maxHealth +
                ", speed = " + speed;
    }

    @Override
    public String getInfo() {
        return "Damage taken = " + (getMaxHealth() - getHealth()) +
                "\nCurrent health = " + getHealth();
    }

    @Override
    public void step(ArrayList<DefaultHero> party, int[] heal) {
        System.out.println("This unit isn't a healer");
    }
}
