import java.util.Scanner;

public class _Phase4 {
    public static void exampleScreen(Scanner scanner){
        UI.clearScreen();
        System.out.println("\n==============================================");
        System.out.println("         HUNTER x HUNTER - MATH CHALLENGE");
        System.out.println("             Phase 4 of Hunter Exam");
        System.out.println("==============================================");
        UI.printGreyText("\nComing soon...");
        scanner.nextLine();
        UI.printGreyText("\nPress Enter to go to the next phase");
        scanner.nextLine();
        _PhaseFinal.main(scanner);
    }
}
