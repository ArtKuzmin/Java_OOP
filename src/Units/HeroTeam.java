package Units;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class HeroTeam {
    public static final int GANG_SIZE = 10;
    public static ArrayList<DefaultHero> wizardTeam = new ArrayList<>();
    public static ArrayList<DefaultHero> monkTeam = new ArrayList<>();

    public static void Init() {

        Random random = new Random();
        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            int value = random.nextInt(4);
            switch (value) {
                case 0 -> wizardTeam.add(new Peasant(wizardTeam, x++, y));
                case 1 -> wizardTeam.add(new Rogue(wizardTeam, x++, y));
                case 2 -> wizardTeam.add(new Sniper(wizardTeam, x++, y));
                case 3 -> wizardTeam.add(new Wizard(wizardTeam, x++, y));
            }
        }
        x = 1;
        y = GANG_SIZE;
        for (int i = 0; i < GANG_SIZE; i++) {
            int value = random.nextInt(4);
            switch (value) {
                case 0 -> monkTeam.add(new Monk(monkTeam, x++, y));
                case 1 -> monkTeam.add(new Peasant(monkTeam, x++, y));
                case 2 -> monkTeam.add(new Lancer(monkTeam, x++, y));
                case 3 -> monkTeam.add(new Crossbowman(monkTeam, x++, y));
            }
        }
        wizardTeam.sort(Comparator.comparingInt(a -> a.speed));
        monkTeam.sort(Comparator.comparingInt(a -> a.speed));
    }

    public static boolean checkForWin(ArrayList<DefaultHero> party) {
        boolean win = false;
        int counter = 0;
        for (DefaultHero hero : party) {
            if (hero.isDead()) {
                counter++;
            }
        }
        if (counter == party.size()) {
            return win = true;
        } else
            return win = false;
    }
}
