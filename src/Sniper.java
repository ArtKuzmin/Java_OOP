public class Sniper extends RangedUnit{
    public Sniper(String name, int attack, int defense, int[] damage, int health, int speed, int shots) {
        super(name, attack, defense, damage, health, speed, shots);
    }
    public Sniper(String name) {
        super(name, 12, 10, new int[]{8,10}, 15, 9, 32);
        this.setName(name);
    }

}
