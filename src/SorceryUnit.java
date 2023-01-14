public abstract class SorceryUnit extends DefaultHero {
    boolean mana = true;
//добавил геттер и сеттер для маны на случай, если в дальшейшем в игре у этих классов можно будет отнимать абилку магии)
    public boolean isMana() {
        return mana;
    }

    public void setMana(boolean mana) {
        this.mana = mana;
    }

    public SorceryUnit(String name, int attack, int defense, int[] damage, int health, int speed) {
        super(name, attack, defense, damage, health, speed);

    }

    @Override
    public String toString() {
        return super.toString() + ", mana = " + mana;
    }
}
