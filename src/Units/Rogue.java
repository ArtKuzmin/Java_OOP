package Units;

public class Rogue extends CloseRangeUnit {

    public Rogue(String name, int attack, int defense, int[] damage, int health, int speed) {
        super(name, attack, defense, damage, health, speed);
    }

    public Rogue(String name) {
        super(name, 8, 3, new int[]{2,4}, 16, 10);
        this.name = name;
    }


}
