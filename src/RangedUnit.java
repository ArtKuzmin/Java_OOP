public abstract class RangedUnit extends DefaultHero {
    int shots;

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public RangedUnit(String name, int attack, int defense, int[] damage, int health, int speed, int shots) {
        super(name, attack, defense, damage, health, speed);
        this.shots = shots;
    }

    @Override
    public String toString() {
        return super.toString() + ", shots = " + shots;
    }
}
