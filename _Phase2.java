import java.util.Scanner;
import java.util.List;

public class _Phase2 {
    public static void exampleScreen(Scanner scanner){
        Player.updatePhase(2);
        UI.clearScreen();
        System.out.println("\n==============================================");
        System.out.println("        HUNTER x HUNTER - COOKING CHALLENGE");
        System.out.println("             Phase 2 of Hunter Exam");
        System.out.println("==============================================");
        UI.printGreyText("\nPress enter to continue...");
        scanner.nextLine();

        int score = 0;
        int PASSING_SCORE = 3;

        UI.clearScreen();
        System.out.println("Menchi: This phase will test your culinary intuition!");
        scanner.nextLine();
        System.out.println("Menchi: Don't think of food as just ingredients—");
        scanner.nextLine();
        System.out.println("think of the soul behind the dish!");
        scanner.nextLine();

        List<String> questions = SQL.runGetResultAll("SELECT * FROM p2Questions ORDER BY RAND() LIMIT 5;");
        int qNum = 1;
        for(String question : questions){
            String[] parts = question.split("::");
            int answer;
            while (true) {
                UI.clearScreen();
                System.out.println("Q" + qNum + ": " + parts[1]);
                System.out.println("  1) " + parts[2]);
                System.out.println("  2) " + parts[3]);
                System.out.print("\nYour answer (1 or 2): ");

                try {
                    answer = Integer.parseInt(scanner.nextLine());
                    if (answer == 1 || answer == 2) break;
                    else System.out.print("Invalid input. Please enter 1 or 2: ");
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter 1 or 2: ");
                }
            }

            if (answer == Integer.parseInt(parts[4])) {
                UI.printBox("Correct!");
                score++;
            } else {
                UI.printBox("Wrong.");
            }
            qNum++;
            System.out.println();
            scanner.nextLine();
        }

        System.out.println("Menchi: You scored " + score + " out of " + questions.size() + ".");
        scanner.nextLine();

        if (score >= PASSING_SCORE) {
            System.out.println("Menchi: You're worthy to proceed to Phase 3!");
            scanner.nextLine();
            UI.printGreyText("Press enter to go to the next phase");
		    scanner.nextLine(); 
            _Phase3.main(scanner);
        } else {
            System.out.println("Menchi: You lack the culinary instinct to be a Hunter.");
            scanner.nextLine();
            System.out.println("Menchi: Better luck next time!");
            scanner.nextLine();
            _PlayerScreen.main(scanner);
        }
           
        scanner.nextLine();
    }
}
