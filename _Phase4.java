import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class _Phase4 {
    static Scanner scanner;

    public static void main(Scanner scanner) {
        Player.updatePhase(4);
        _Phase4.scanner = scanner;
        UI.clearScreen();
        System.out.println("\n==============================================");
        System.out.println("         HUNTER x HUNTER - MATH CHALLENGE");
        System.out.println("             Phase 4 of Hunter Exam");
        System.out.println("==============================================");
        UI.printGreyText("\nPress enter to continue...");
        scanner.nextLine();

        UI.clearScreen();
        System.out.println("Lippo: Welcome to Zevil Island. This phase will test not only your survival skills but also your intellect.");
        scanner.nextLine();
        System.out.println("Lippo: Answer the following math problems correctly to proceed. Remember, only those who can think swiftly will survive.\n");
        scanner.nextLine();
        
        List<Question> selectedQuestions = getRandomQuestions();
        int score = 0;
        int questionNumber = 1;

        for (Question q : selectedQuestions) {
            int answer;

            while (true) {
                UI.clearScreen();
                System.out.println("Question " + questionNumber + ": " + q.text);
                System.out.print("Your answer: ");
                
                try {
                    answer = Integer.parseInt(scanner.nextLine());
                    if (answer >= 1 && answer <= 404) break;
                    else System.out.println("\rEnter a number between 1 and 404:");
                } catch (NumberFormatException e) {
                    System.out.println("\rPlease enter a valid number:");
                }
            }

            if (answer == q.answer) {
                UI.printBox("Correct!");
                score++;
            } else {
                UI.printBox("Wrong. Correct answer: " + q.answer);
            }
            UI.printGreyText("\nPress enter to continue...");
            scanner.nextLine();
            questionNumber++;
        }

        System.out.println("You scored " + score + " out of 5.");
        if (score >= 3) {
            System.out.println("Lippo: Impressive. You've demonstrated both intellect and composure under pressure.");
            scanner.nextLine();
            System.out.println("Lippo: Proceed to the final phase. Your journey as a Hunter continues.\n");
            scanner.nextLine();

            Player.currentScore += 100;
            Player.updateScore();
            UI.printGreyText("\nPress enter to go to the next phase");
		    scanner.nextLine(); 
            _PhaseFinal.main(scanner);
        } else {
            Player.failHunterExam();
            
            System.out.println("Lippo: Unfortunately, you did not meet the required score.");
            scanner.nextLine();
            System.out.println("Lippo: Survival on Zevil Island is unforgiving. Better luck next time.\n");
            scanner.nextLine();

            UI.printGreyText("\nPress Enter To Continue...");
            scanner.nextLine();
            _PlayerScreen.main(scanner);
        }
    }

    static List<Question> getRandomQuestions() {
        List<Question> questions = new ArrayList<>();
        List<String> result = SQL.runGetResultAll("SELECT * FROM p4Questions ORDER BY RAND() LIMIT 5;");

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