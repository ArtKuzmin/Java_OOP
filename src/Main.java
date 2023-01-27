import Units.*;

import java.util.*;

public class Main {
    public static final int GANG_SIZE = 5;
    public static ArrayList<DefaultHero> whiteSide;
    public static ArrayList<DefaultHero> darkSide;

    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleView.view();
            whiteSide.forEach(n -> n.step(darkSide));
            darkSide.forEach(n -> n.step(whiteSide));
            scanner.nextLine();
        }
    }

    private static void init() {
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> whiteSide.add(new Peasant(whiteSide, x, y++));
                case 1 -> whiteSide.add(new Rogue(whiteSide, x, y++));
                case 2 -> whiteSide.add(new Sniper(whiteSide, x, y++));
                default -> whiteSide.add(new Monk(whiteSide, x, y++));
            }
        }
        Collections.reverse(whiteSide);

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {

            switch (new Random().nextInt(4)) {
                case 0 -> darkSide.add(new Peasant(darkSide, x, y++));
                case 1 -> darkSide.add(new Lancer(darkSide, x, y++));
                case 2 -> darkSide.add(new Crossbowman(darkSide, x, y++));
                default -> darkSide.add(new Wizard(darkSide, x, y++));
            }
        }
        Collections.reverse(darkSide);
    }
}
