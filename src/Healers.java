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
    @Override
    public void step(ArrayList<DefaultHero> party, int[] heal) {
        double maxDamage = 0;
        int index = 0;
        for (int i = 0; i < party.size(); i++) {
            double damage = party.get(i).getMaxHealth() - party.get(i).getHealth();
            if (damage > maxDamage && !(party.get(i) instanceof Healers)) {
                maxDamage = damage;
                index = i;
            }
        }
        party.get(index).setHealth(Math.abs(heal[0]));
        System.out.println(party.get(index) + " is cured, health increased by " + Math.abs(heal[0]));
    }
}

