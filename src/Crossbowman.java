public class Crossbowman extends RangedUnit {
    public Crossbowman(String name, int attack, int defense, int[] damage, int health, int speed, int shots) {
        super(name, attack, defense, damage, health, speed, shots);
    }
    public Crossbowman(String name) {
        super(name, 6, 3, new int[]{2,3}, 10, 4, 16);
        this.setName(name);
    }
}
