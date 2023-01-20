
public class Mage extends Healers {
    public Mage(String name, int attack, int defense, int[] damage, int health, int speed, boolean mana) {
        super(name, attack, defense, damage, health, speed);
    }

    public Mage(String name) {
        super(name, 17, 12, new int[]{-5}, 30, 9);
        this.setName(name);
    }
}
