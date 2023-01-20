import java.util.ArrayList;

public abstract class Healers extends DefaultHero implements HealAndInfo {
    private boolean mana = true;

    //добавил геттер и сеттер для маны на случай, если в дальшейшем в игре у этих классов можно будет отнимать абилку магии)
    public boolean isMana() {
        return mana;
    }

    public void setMana(boolean mana) {
        this.mana = mana;
    }

    public Healers(String name, int attack, int defense, int[] damage, int health, int speed) {
        super(name, attack, defense, damage, health, speed);
    }

    @Override
    public String toString() {
        return super.toString() + ", mana = " + mana;
    }

    //т.к. хилеры у нас изначально с самым большим количеством хп, то и повреждение в кострукторе они чаще всего получают максимальное.
    // Поэтому сделал так, что сами себя они хилить не умеют
    //плюс поправил сеттер health, чтобы нельзя было установить уровень хп выше максимального
    @Override
    public void step(ArrayList<DefaultHero> party) {
        double maxDamage = 100;
        int index = 0;
        int indexOfHealer = 0;
        for (int i = 0; i < party.size(); i++) {
            double damage = (double) (party.get(i).getHealth() * 100) / party.get(i).getMaxHealth();
            if (damage < maxDamage && !(party.get(i) instanceof Healers)) {
                maxDamage = damage;
                index = i;
            }
            if (party.get(i) instanceof Healers)
                indexOfHealer = i;
        }
        party.get(index).setHealth(party.get(index).getHealth() - party.get(indexOfHealer).getDamage()[0]);
        System.out.println(party.get(index) + " is cured, health increased by " + Math.abs(party.get(indexOfHealer).getDamage()[0]));
    }
}

