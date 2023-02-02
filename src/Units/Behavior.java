package Units;

import java.util.ArrayList;

public interface Behavior {
    void step(ArrayList<DefaultHero> party);

    String getInfo();
//    Vector2  findTarget(ArrayList<DefaultHero> party);


}
