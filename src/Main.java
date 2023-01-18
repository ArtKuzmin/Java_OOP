import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        List<DefaultHero> peasants = createFiveHero(() -> new Peasant(Names.randName()));
//        peasants.forEach(System.out::println);
//        System.out.println("-------------------");
//
//        List<DefaultHero> snipers = createFiveHero(() -> new Sniper(Names.randName()));
//        snipers.forEach(System.out::println);
//        System.out.println("-------------------");
//
//        List<DefaultHero> crossbowmen = createFiveHero(() -> new Crossbowman(Names.randName()));
//        crossbowmen.forEach(System.out::println);
//        System.out.println("-------------------");
//
//        List<DefaultHero> rogues = createFiveHero(() -> new Rogue(Names.randName()));
//        rogues.forEach(System.out::println);
//        System.out.println("-------------------");
//
//        List<DefaultHero> spearmen = createFiveHero(() -> new Spearman(Names.randName()));
//        spearmen.forEach(System.out::println);
//        System.out.println("-------------------");
//
//        List<DefaultHero> mages = createFiveHero(() -> new Mage(Names.randName()));
//        mages.forEach(System.out::println);
//        System.out.println("-------------------");
//
//        List<DefaultHero> monks = createFiveHero(() -> new Monk(Names.randName()));
//        monks.forEach(System.out::println);
//        System.out.println("-------------------");
//
//        List<DefaultHero> randList = createListOfUnits(50);
//        String unitClass = "Mage";
//        List<DefaultHero> classUnits = pickUnitClass(randList, unitClass);
//        System.out.printf("List of %s from 50 units of random classes: \n", unitClass);
//        for (DefaultHero a : classUnits) {
//            System.out.println(a);
//        }


        ArrayList<DefaultHero> partyOne = createParty(10, 1);
        partyOne.forEach(s -> {
            System.out.println(s);
            System.out.println(s.getInfo());
        });
        System.out.println("---------");
        for (int i = 0; i < partyOne.size(); i++) {
                partyOne.get(i).step(partyOne, partyOne.get(i).getDamage());
        }

//
//        System.out.println("---------");

        ArrayList<DefaultHero> partyTwo = createParty(10, 0);
//        partyTwo.forEach(System.out::println);


    }

    public static ArrayList<DefaultHero> createUnitsOfSameClass(Supplier<? extends DefaultHero> heroSupplier, int partySize) {
        ArrayList<DefaultHero> arr = new ArrayList<>();
        for (int i = 0; i < partySize; i++) {
            arr.add(heroSupplier.get());
        }
        return arr;
    }

    public static ArrayList<DefaultHero> createParty(int n, int party) {
        ArrayList<DefaultHero> randList = new ArrayList<>();
        if (party == 1) {
            for (int i = 0; i < n; i++) {
                int rand = new Random().nextInt(4);
                switch (rand) {
                    case (0) -> randList.add(new Mage(Names.randName()));
                    case (1) -> randList.add(new Peasant(Names.randName()));
                    case (2) -> randList.add(new Rogue(Names.randName()));
                    case (3) -> randList.add(new Sniper(Names.randName()));
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                int rand = new Random().nextInt(4);
                switch (rand) {
                    case (0) -> randList.add(new Monk(Names.randName()));
                    case (1) -> randList.add(new Peasant(Names.randName()));
                    case (2) -> randList.add(new Spearman(Names.randName()));
                    case (3) -> randList.add(new Crossbowman(Names.randName()));
                }
            }

        }
        return randList;
    }

    public static List<DefaultHero> pickUnitClass(List<DefaultHero> randList, String classOfUnit) {
        List<DefaultHero> arr = new ArrayList<>(randList);
        arr.removeIf(item -> !String.valueOf(item.getClass()).replace("class ", "").equals(classOfUnit));
        return arr;
    }
}