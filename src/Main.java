import Units.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DefaultHero> partyOne = createParty(10, 1);
        partyOne.sort(Collections.reverseOrder());
        partyOne.forEach(s -> System.out.println(s.getInfo()));
        System.out.println("-------------------");
        while (true){
            System.out.println("Press enter for next step, '0' to quit");
            sc.nextLine();
            if(sc.nextLine().equals("0"))
                break;
            System.out.println("PartyOne's move:");
            partyOne.forEach(s -> s.step(partyOne));
        }
    }

    public static ArrayList<DefaultHero> createParty(int n, int party) {
        ArrayList<DefaultHero> randList = new ArrayList<>();
        if (party == 1) {
            randList.add(new Mage(Names.randName()));
            randList.add(new Peasant(Names.randName()));
            randList.add(new Rogue(Names.randName()));
            randList.add(new Sniper(Names.randName()));
            for (int i = 0; i < n - 4; i++) {
                int rand = new Random().nextInt(4);
                switch (rand) {
                    case (0) -> randList.add(new Mage(Names.randName()));
                    case (1) -> randList.add(new Peasant(Names.randName()));
                    case (2) -> randList.add(new Rogue(Names.randName()));
                    case (3) -> randList.add(new Sniper(Names.randName()));
                }
            }
        } else {
            randList.add(new Monk(Names.randName()));
            randList.add(new Peasant(Names.randName()));
            randList.add(new Spearman(Names.randName()));
            randList.add(new Crossbowman(Names.randName()));
            for (int i = 0; i < n - 4; i++) {
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
}

