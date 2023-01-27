package Units;

import java.util.ArrayList;

public class Peasant extends DefaultHero {

    protected boolean supply;

    public Peasant(ArrayList<DefaultHero> side, int x, int y) {
        super(Names.randName(), 1, 1, new int[]{1}, 1, 3, side, new Vector2(x, y));
        this.supply = true;
    }

    @Override
    public String toString() {
        return super.toString() + ", supply = " + supply;
    }

    @Override
    public void step(ArrayList<DefaultHero> party) {
        this.supply = true;
        System.out.println("Peasant rested and ready to supply");
    }
}
