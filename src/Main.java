import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<DefaultHero> peasants = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            peasants.add(new Peasant(Names.randName()));
            System.out.println(peasants.get(i));
        }
        System.out.println("-------------------");

        List<DefaultHero> snipers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            snipers.add(new Sniper(Names.randName()));
            System.out.println(snipers.get(i));
        }
        System.out.println("-------------------");

        List<DefaultHero> crossbowmen = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            crossbowmen.add(new Crossbowman(Names.randName()));
            System.out.println(crossbowmen.get(i));
        }
        System.out.println("-------------------");

        List<DefaultHero> rogues = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rogues.add(new Rogue(Names.randName()));
            System.out.println(rogues.get(i));
        }
        System.out.println("-------------------");

        List<DefaultHero> spearmen = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            spearmen.add(new Spearman(Names.randName()));
            System.out.println(spearmen.get(i));
        }
        System.out.println("-------------------");

        List<DefaultHero> mages = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mages.add(new Mage(Names.randName()));
            System.out.println(mages.get(i));
        }
        System.out.println("-------------------");

        List<DefaultHero> monks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            monks.add(new Monk(Names.randName()));
            System.out.println(monks.get(i));
        }
        System.out.println("-------------------");

        List<DefaultHero> randList = new ArrayList<>();
        createListOfUnits(randList, 50);
        String unitClass = "Mage";
        List<DefaultHero> listOfUnits = pickUnitClass(randList, unitClass);
        System.out.printf("List of %s from 50 units of random classes: \n", unitClass);
        for (DefaultHero a : listOfUnits) {
            System.out.println(a);
        }
    }

    public static void createListOfUnits(List<DefaultHero> randList, int n) {
        for (int i = 0; i < n; i++) {
            int rand = new Random().nextInt(6);
            switch (rand) {
                case (0): {
                    randList.add(new Monk(Names.randName()));
                }
                case (1): {
                    randList.add(new Mage(Names.randName()));
                }
                case (2): {
                    randList.add(new Peasant(Names.randName()));
                }
                case (3): {
                    randList.add(new Rogue(Names.randName()));
                }
                case (4): {
                    randList.add(new Spearman(Names.randName()));
                }
                case (5): {
                    randList.add(new Crossbowman(Names.randName()));
                }
                case (6): {
                    randList.add(new Sniper(Names.randName()));
                }
            }
        }
    }

    public static List<DefaultHero> pickUnitClass(List<DefaultHero> randList, String classOfUnit) {
        List<DefaultHero> listOfUnits = new ArrayList<>();
        for (DefaultHero a : randList) {
            String cl = String.valueOf(a.getClass()).replace("class ", "");
            if (cl.equals(classOfUnit)) {
                listOfUnits.add(a);
            }
        }
        return listOfUnits;
    }
}