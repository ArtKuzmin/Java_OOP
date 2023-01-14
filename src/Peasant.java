public class Peasant extends DefaultHero {
    boolean supply = true;
//добавил геттер и сеттер для доставки на случай, если в дальшейшем в игре у этих крестьянина можно будет отнимать абилку)

    public boolean isSupply() {
        return supply;
    }

    public void setSupply(boolean supply) {
        this.supply = supply;
    }

    public Peasant(String name, int attack, int defense, int[] damage, int health, int speed) {
        super(name, attack, defense, damage, health, speed);

    }

    public Peasant(String name) {
        super(name, 1, 1, new int[]{1}, 1, 3);
        this.name = name;

    }

    @Override
    public String toString() {
        return super.toString() +  ", supply = " + supply;
    }
}
