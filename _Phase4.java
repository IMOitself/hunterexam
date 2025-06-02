import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class _Phase4 {
    static Scanner scanner;

    public static void main(Scanner scanner) {
        _Phase4.scanner = scanner;
        UI.clearScreen();
        System.out.println("\n==============================================");
        System.out.println("         HUNTER x HUNTER - MATH CHALLENGE");
        System.out.println("             Phase 4 of Hunter Exam");
        System.out.println("==============================================");
        UI.printGreyText("\nPress enter to continue...");
        scanner.nextLine();
        
        List<Question> selectedQuestions = getRandomQuestions();
        int score = 0;

        for (Question q : selectedQuestions) {
            System.out.println("Solve: " + q.text);
            int userAnswer = getValidInput();
            if (userAnswer == q.answer) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong. Correct answer: " + q.answer + "\n");
            }
        }

        System.out.println("You scored " + score + " out of 5.");
        if (score >= 3) {
            System.out.println("🎉 Congratulations! You passed Phase 4.");
            Player.currentScore += 100;
            Player.updateScore();
            UI.printGreyText("\nPress Enter To Continue...");
            scanner.nextLine();
            _PhaseFinal.main(scanner);
        } else {
            System.out.println("❌ You failed Phase 4. Try again.");
            UI.printGreyText("\nPress Enter To Continue...");
            scanner.nextLine();
            _PlayerScreen.main(scanner);
        }
    }

    static int getValidInput() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 404) return input;
                else System.out.println("Enter a number between 1 and 404:");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number:");
            }
        }
    }

    static List<Question> getRandomQuestions() {
        List<Question> questions = new ArrayList<>();
        List<String> result = SQL.runGetResultAll("SELECT * FROM p4Questions;");

        for (String line : result) {
            String[] parts = line.split("::");
            questions.add(new Question(parts[1], Integer.parseInt(parts[2])));
        }
        
        return questions;
    }

    
    static class Question {
        String text;
        int answer;

        Question(String text, int answer) {
            this.text = text;
            this.answer = answer;
        }
    }
}