import Units.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HeroTeam.Init();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            ConsoleView.view();

            if (HeroTeam.checkForWin(HeroTeam.monkTeam)) {
                System.out.println("Wizard Team won!");
                break;
            }
            for (int i = HeroTeam.GANG_SIZE - 1; i > 0; i--) {
                System.out.print("Wizard team: \t");
                HeroTeam.wizardTeam.get(i).step(HeroTeam.monkTeam);
                System.out.print("Monk team: \t\t");
                HeroTeam.monkTeam.get(i).step(HeroTeam.wizardTeam);
            }

            System.out.println();
            if (HeroTeam.checkForWin(HeroTeam.wizardTeam)) {
                System.out.println("Monk Team won!");
                break;
            }
            scanner.nextLine();

        }

    }

}

