import Units.*;
//
import java.util.*;
//
//public class Main {
//    public static final int GANG_SIZE = 10;
//    public static ArrayList<DefaultHero> whiteSide;
//    public static ArrayList<DefaultHero> darkSide;
//
//    public static void main(String[] args) {
//        init();
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            ConsoleView.view();
//            System.out.println("White Side's turn:");
//            whiteSide.forEach(n -> n.step(darkSide));
//            System.out.println();
//            System.out.println("Dark Side's turn:");
//            darkSide.forEach(n -> n.step(whiteSide));
//            scanner.nextLine();
//
//        }
//    }
//
//
//    private static void init() {
//        whiteSide = new ArrayList<>();
//        darkSide = new ArrayList<>();
//
//        int x = 1;
//        int y = 1;
//        for (int i = 0; i < GANG_SIZE; i++) {
//            switch (new Random().nextInt(4)) {
//                case 0 -> whiteSide.add(new Peasant(whiteSide, x, y++));
//                case 1 -> whiteSide.add(new Rogue(whiteSide, x, y++));
//                case 2 -> whiteSide.add(new Sniper(whiteSide, x, y++));
//                default -> whiteSide.add(new Monk(whiteSide, x, y++));
//            }
//        }
//
//        x = GANG_SIZE;
//        y = 1;
//        for (int i = 0; i < GANG_SIZE; i++) {
//
//            switch (new Random().nextInt(4)) {
//                case 0 -> darkSide.add(new Peasant(darkSide, x, y++));
//                case 1 -> darkSide.add(new Lancer(darkSide, x, y++));
//                case 2 -> darkSide.add(new Crossbowman(darkSide, x, y++));
//                default -> darkSide.add(new Wizard(darkSide, x, y++));
//            }
//        }
//    }
//}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HeroTeam.Init();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            ConsoleView.view();
            System.out.println("Monk Side's turn:");
            HeroTeam.wizardTeam.forEach(n -> n.step(HeroTeam.monkTeam));
            System.out.println();
            System.out.println("Wizard Side's turn:");
            HeroTeam.monkTeam.forEach(n -> n.step(HeroTeam.wizardTeam));
            scanner.nextLine();

//            ConsoleView.view();
//            System.out.println("Press ENTER");
//            scanner.nextLine();
//            gameStep();
////            if(HeroTeam.deadTeam(HeroTeam.monkTeam) || HeroTeam.deadTeam(HeroTeam.wizardTeam))
////            {
////                ConsoleView.view();
////                System.out.println("End");
////                break;
////            }
        }

    }

    public static void gameStep() {
        for (int i = 0; i < HeroTeam.GANG_SIZE; i++) {
            if (HeroTeam.monkTeam.get(i).getName().equals("Crossbowman") ||
                    HeroTeam.monkTeam.get(i).getName().equals("Lancer"))
                HeroTeam.monkTeam.get(i).step(HeroTeam.wizardTeam);
            if (HeroTeam.wizardTeam.get(i).getName().equals("Sniper") ||
                    HeroTeam.wizardTeam.get(i).getName().equals("Rogue"))
                HeroTeam.wizardTeam.get(i).step(HeroTeam.monkTeam);
        }

        for (int i = 0; i < HeroTeam.GANG_SIZE; i++) {
            if (HeroTeam.monkTeam.get(i).getName().equals("Monk"))
                HeroTeam.monkTeam.get(i).step(HeroTeam.wizardTeam);
            if (HeroTeam.wizardTeam.get(i).getName().equals("Wizard"))
                HeroTeam.wizardTeam.get(i).step(HeroTeam.monkTeam);
        }

        for (int i = 0; i < HeroTeam.GANG_SIZE; i++) {
            if (HeroTeam.monkTeam.get(i).getName().equals("Peasant"))
                HeroTeam.monkTeam.get(i).step(HeroTeam.wizardTeam);
            if (HeroTeam.wizardTeam.get(i).getName().equals("Peasant"))
                HeroTeam.wizardTeam.get(i).step(HeroTeam.monkTeam);
        }
    }
}

