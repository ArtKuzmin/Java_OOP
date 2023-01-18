public class Monk extends Healers {
    public Monk(String name, int attack, int defense, int[] damage, int health, int speed, boolean mana) {
        super(name, attack, defense, damage, health, speed);
    }
    public Monk(String name) {
        super(name, 12, 7, new int[]{-4}, 30, 5);
        this.setName(name);
    }
}
