import java.util.Arrays;

public abstract class DefaultHero {
    private String name;
    private int attack;
    private int defense;
    private int[] damage;
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

    public DefaultHero(String name, int attack, int defense, int[] damage, int health, int speed) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return getClass() +
                ", Name = '" + name + '\'' +
                ", attack = " + attack +
                ", defense = " + defense +
                ", damage = " + Arrays.toString(damage) +
                ", health = " + health +
                ", speed = " + speed;
    }
}
