import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        scanner.nextLine();

        int score = 0;

        UI.clearScreen();
        System.out.println("\n🧪 Phase 2: Cooking Challenge Begins!");
        System.out.println("Menchi: \"This phase will test your culinary intuition! Don't think of food as just ingredients—think of the soul behind the dish!\"\n");

        List<String> questions = SQL.runGetResultAll("SELECT * FROM p2questions ORDER BY RANDOM() LIMIT 5;");
        for(String question : questions){
            System.out.println(question);
            
        }
        scanner.nextLine();
        
        /** 
        int qNum = 1;
        while (rs.next()) {
            System.out.println("Q" + qNum + ": " + rs.getString("question_text"));
            System.out.println("  1) " + rs.getString("choice_1"));
            System.out.println("  2) " + rs.getString("choice_2"));
            System.out.print("Your answer (1 or 2): ");

            int answer;
            while (true) {
                try {
                    answer = Integer.parseInt(scanner.nextLine());
                    if (answer == 1 || answer == 2) break;
                    else System.out.print("Invalid input. Please enter 1 or 2: ");
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter 1 or 2: ");
                }
            }

            if (answer == rs.getInt("correct_answer")) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong.");
            }
            qNum++;
            System.out.println();
        }

        System.out.println("🍽️ Menchi: \"You scored " + score + " out of " + TOTAL_QUESTIONS + ".\"");

        if (score >= PASSING_SCORE) {
            System.out.println("🎉 Menchi: \"Impressive palate! You're worthy to proceed to Phase 3!\"");
            // Call Phase 3 method or flag here
        } else {
            System.out.println("💥 Menchi: \"Better luck next time! You lack the culinary instinct to be a Hunter.\"");
            // End game or restart
        }
        **/
    }
}
