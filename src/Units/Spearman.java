package Units;

public class Spearman extends CloseRangeUnit {


    public Spearman(String name, int attack, int defense, int[] damage, int health, int speed) {
        super(name, attack, defense, damage, health, speed);
    }

    public Spearman(String name) {
        super(name, 4, 5, new int[]{1, 3}, 10, 4);
        this.name = name;
    }


}
