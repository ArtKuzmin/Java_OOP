import java.util.ArrayList;

public interface HealAndInfo {
    public void step(ArrayList<DefaultHero> party, int[] heal);

    String getInfo();
}
