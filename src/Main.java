import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        ArrayList<DefaultHero> partyOne = createParty(10, 1);
        partyOne.forEach(s -> System.out.println(s.getInfo()));
        System.out.println("---------");
        partyOne.forEach(s -> s.step(partyOne));
//        System.out.println("---------");
//        partyOne.forEach(s -> System.out.println(s.getInfo()));

        System.out.println("------------------------------");
        ArrayList<DefaultHero> partyTwo = createParty(10, 0);
        partyTwo.forEach(s -> System.out.println(s.getInfo()));
        System.out.println("---------");
        partyTwo.forEach(s -> s.step(partyTwo));
//        System.out.println("---------");
//        partyTwo.forEach(s -> System.out.println(s.getInfo()));
//        System.out.println("---------");
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