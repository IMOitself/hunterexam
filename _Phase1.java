import java.util.*;

public class _Phase1 {

    static Scanner scanner = new Scanner(System.in);
	
	static int correctCount = 0;
	static int wrongInput = 0;
	public static final int TIME_LIMIT = 10; // seconds

    public static Timer timer;
    public static int timeLeft;
    public static boolean isRunning = true;
    
    public static void exampleScreen(){
        UI.clearScreen();
        System.out.println("\n==============================================");
        System.out.println("    HUNTER x HUNTER - SPEED CHALLENGE");
        System.out.println("             Phase 1 of Hunter Exam");
        System.out.println("==============================================");
        UI.printGreyText("\nPress enter to continue...");
        scanner.nextLine();

        Collections.shuffle(wordsToGuess);

        int score = 0;

        for (String word : wordsToGuess) {
            Timer timer = new Timer(true);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    ignoreInput = true;
                    UI.clearScreen();
                    UI.printBox("Time runs out");
                    UI.printGreyText("Press Enter to continue...");
                }
            }, 2000);

            ignoreInput = false;
            UI.clearScreen();
            UI.printBox("Type the word in 2 seconds");
            System.out.println("\nEnter the word: " + word);
            String input = scanner.nextLine();
            
            timer.cancel();
            if(!ignoreInput){
                if(input.equalsIgnoreCase(word)){
                    UI.printBox("Correct");
                    score++;
                }
                else{
                    UI.printBox("Wrong");
                }
                
                UI.printGreyText("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        UI.clearScreen();
        UI.printBox("Your final score is: " + score + "/" + wordsToGuess.size());
        UI.printGreyText("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
