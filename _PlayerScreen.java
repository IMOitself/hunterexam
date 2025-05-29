import java.util.Scanner;

public class _PlayerScreen {
    public static void exampleScreen(Scanner scanner){
        UI.clearScreen();
        UI.printBox("Username: " + Player.username + "\nPassword: " + Player.password + "\nCurrent Phase: " + Player.currentPhase + "\nCurrent Score: " + Player.currentScore);
        scanner.nextLine();
        _Intro.mainMenu(scanner);
    }
}
