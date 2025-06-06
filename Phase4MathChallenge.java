import java.sql.*;
import java.util.*;

public class Phase4MathChallenge {

    private static final int TOTAL_QUESTIONS = 5;
    private static final int PASSING_SCORE = 3;

    public static void startPhase4(Connection conn, int hunterId) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("\n🧠 Phase 4: Zevil Island – Math Challenge");
        System.out.println("Lippo: \"Welcome to Zevil Island. This phase will test not only your survival skills but also your intellect.\"");
        System.out.println("Lippo: \"Answer the following math problems correctly to proceed. Remember, only those who can think swiftly will survive.\"\n");

        PreparedStatement stmt = conn.prepareStatement(
            "SELECT * FROM questions WHERE phase = 4 ORDER BY RANDOM() LIMIT ?"
        );
        stmt.setInt(1, TOTAL_QUESTIONS);
        ResultSet rs = stmt.executeQuery();

        int questionNumber = 1;
        while (rs.next()) {
            String questionText = rs.getString("question_text");
            int correctAnswer = rs.getInt("correct_answer");

            System.out.println("Question " + questionNumber + ": " + questionText);
            System.out.print("Your answer: ");

            int playerAnswer;
            while (true) {
                try {
                    playerAnswer = Integer.parseInt(scanner.nextLine());
                    if (playerAnswer >= 1 && playerAnswer <= 404) {
                        break;
                    } else {
                        System.out.print("Please enter a whole number between 1 and 404: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a whole number: ");
                }
            }

            if (playerAnswer == correctAnswer) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect. The correct answer was: " + correctAnswer);
            }

            questionNumber++;
            System.out.println();
        }

        System.out.println("Lippo: \"You answered " + score + " out of " + TOTAL_QUESTIONS + " questions correctly.\"");

        if (score >= PASSING_SCORE) {
            System.out.println("Lippo: \"Impressive. You've demonstrated both intellect and composure under pressure.\"");
            System.out.println("Lippo: \"Proceed to the final phase. Your journey as a Hunter continues.\"\n");
            // Proceed to next phase
        } else {
            System.out.println("Lippo: \"Unfortunately, you did not meet the required score.\"");
            System.out.println("Lippo: \"Survival on Zevil Island is unforgiving. Better luck next time.\"\n");
            // End or restart the phase
        }
    }
}
