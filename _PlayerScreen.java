import java.util.Scanner;

public class _PlayerScreen {
    public static void main(Scanner scanner){
        UI.clearScreen();
        
        UI.printBox("1. NEW GAME");

        if(Player.currentPhase > 1){
            UI.printBox("2. CONTINUE");
        }

        UI.printBox("3. TEST PHASES");

        UI.colorGrey();
        UI.printBox("Username: " + Player.username + "\nPassword: " + Player.password + "\nCurrent Phase: " + Player.currentPhase + "\nCurrent Score: " + Player.currentScore);
        UI.colorReset();

        String input = scanner.nextLine();

        switch (input) {
            case "1":
            case "2":
                playGame(scanner);
                break;
            case "3":
                testScreen(scanner);
                break;
            default:
                main(scanner);
                break;
        }
    }

    public static void playGame(Scanner scanner){
        switch (Player.currentPhase) {
            case 2:
                _Phase2.exampleScreen(scanner);
                break;
            case 3:
                _Phase3.main(scanner);
                break;
            case 4:
                _Phase4.main(scanner);
                break;
            case 5:
                _PhaseFinal.main(scanner);
                break;
            case 1:
            default:
                String[] newGameText = {
                "Another year for the Hunter Exam.",
                "Due to the large number of people who wish to become Hunters,",
                "the exam phases tend to be exceptionally difficult.",
                "This year you will surely pass the exam.",
                "Good luck, " + Player.username + "."
                };
                for(int i = 0; i < newGameText.length; i++){
                    UI.clearScreen();
                    String text = "";
                    for(int j = 0; j <= i; j++){
                        text += newGameText[j] + "\n";
                    }
                    UI.printBox(text);
                    UI.printGreyText("\nPress enter to continue...");
                    scanner.nextLine();
                }
                
                _Phase1.main(new String[]{});
                break;
        }
    }

    public static void testScreen(Scanner scanner) {
        UI.clearScreen();
        UI.printBox("1. Phase 1\n2. Phase 2\n3. Phase 3\n4. Phase 4\n5. Final\n6. Main Menu");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                _Phase1.main(new String[]{});
                break;
            case "2":
                _Phase2.exampleScreen(scanner);
                break;
            case "3":
                _Phase3.main(scanner);
                break;
            case "4":
                _Phase4.main(scanner);
                break;
            case "5":
                _PhaseFinal.main(scanner);
                break;
			case "6":
                _Intro.homeScreen(scanner);
                break;
            default:
                testScreen(scanner);
                break;
        }
    }
}
