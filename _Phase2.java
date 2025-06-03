import java.util.Scanner;

public class _Phase2 {
    public static void exampleScreen(Scanner scanner){
        Player.updatePhase(2);
        UI.clearScreen();
        System.out.println("\n==============================================");
        System.out.println("        HUNTER x HUNTER - COOKING CHALLENGE");
        System.out.println("             Phase 2 of Hunter Exam");
        System.out.println("==============================================");
        UI.printGreyText("\nComing soon...");
        scanner.nextLine();
        UI.printGreyText("\nPress Enter to go to the next phase");
        scanner.nextLine();
        _Phase3.main(scanner);
    }
}
