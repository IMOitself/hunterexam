import java.util.Scanner;

public class _PlayerScreen {
    public static void exampleScreen(Scanner scanner){
        UI.clearScreen();
        UI.printGreyText("[ Work in progress ]");
        UI.printBox("Username: " + Player.username + "\nPassword: " + Player.password + "\nCurrent Phase: " + Player.currentPhase + "\nCurrent Score: " + Player.currentScore);
        UI.printGreyText("\nPress Enter To go to Main Menu...\n0. Test hehe");
        String input = scanner.nextLine();
        if(input.equals("0")){
            testScreen(scanner);
        }
        else{
            _Intro.mainMenu(scanner);
        }
    }

    public static void testScreen(Scanner scanner) {
        String input = "";

        UI.clearScreen();
        UI.printBox("1. Phase 1\n2. Phase 2\n3. Phase 3\n4. Phase 4\n5. Final\n6. Back");
        input = scanner.nextLine();

        switch (input) {
            case "1":
                _Phase1.exampleScreen(scanner);
                break;
            case "2":
                _Phase2.exampleScreen(scanner);
                break;
            case "3":
                _Phase3.exampleScreen(scanner);
                break;
            case "4":
                _Phase4.exampleScreen(scanner);
                break;
            case "5":
                _PhaseFinal.exampleScreen(scanner);
                break;
            case "6":
                _Intro.mainMenu(scanner);
                break;
            default:
                testScreen(scanner);
                break;
        }
    }
}
