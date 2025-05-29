import java.util.Scanner;

public class _PlayerScreen {
    public static void exampleScreen(Scanner scanner){
        UI.clearScreen();
        UI.printGreyText("[ Work in progress ]");
        UI.printBox("Username: " + Player.username + "\nPassword: " + Player.password + "\nCurrent Phase: " + Player.currentPhase + "\nCurrent Score: " + Player.currentScore);
        UI.printGreyText("\nPress Enter to test each phases");
        scanner.nextLine();
		testScreen(scanner);
        
    }

    public static void testScreen(Scanner scanner) {
        UI.clearScreen();
        UI.printBox("1. Phase 1\n2. Phase 2\n3. Phase 3\n4. Phase 4\n5. Final\n6. Main Menu\n7. Back");
        String input = scanner.nextLine();

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
                _Intro.homeScreen(scanner);
                break;
            case "7":
                _PlayerScreen.exampleScreen(scanner);
                break;
            default:
                testScreen(scanner);
                break;
        }
    }
}
