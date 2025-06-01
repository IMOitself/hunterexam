import java.util.*;

public class hunterProject {
	static Scanner scanner = new Scanner(System.in);
	
	static int correctCount = 0;
	static int wrongInput = 0;
	public static final int TIME_LIMIT = 10; // seconds

    public static Timer timer;
    public static int timeLeft;
    public static boolean isRunning = true;
    
	public static void main(String[] args) {
		
		exampleScreen();
		
		while (true) {
        	
            System.out.println("=== DEMO MENU ===");
            System.out.println("SELECT DIFFICULTY");
            System.out.println("(0) EASY");
            System.out.println("(1) NORMAL");
            System.out.println("(2) HARD");
            
            System.out.print("Input: ");
        	
            String mainInput = scanner.nextLine();
            
        	if (mainInput.equals("0")) {
        		easy.startGameEasy();
        		break;
        	}
        	if (mainInput.equals("1")) {
        		normal.startGameNorm();
        		break;
        	}
           	if (mainInput.equals("2")) {
        		difficult.startGamediff();
        		break;
        	}
        }
        scanner.close();

	}
	
    public static void exampleScreen(){
//        UI.clearScreen();
        System.out.println("\n==============================================");
        System.out.println("    HUNTER x HUNTER - SPEED CHALLENGE");
        System.out.println("             Phase 1 of Hunter Exam");
        System.out.println("==============================================");
//        UI.printGreyText("\nPress enter to continue...");
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();

    }
	
	public static void startTimer() {
	    timer = new Timer();
	    timeLeft = TIME_LIMIT;

	    timer.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	            timeLeft--;
//	            System.out.print(timeLeft + " ");

	            if (timeLeft <= 0) {
                    timer.cancel();
                    isRunning = false;
                    gameOverDueToTimeout();
	            }
	        }
	    }, 1000, 1000);
	}
	
    public static void resetTimer() {
        timer.cancel();  // Stop current timer
        startTimer();    // Start new timer
    }
    
    private static void gameOverDueToTimeout() {
        System.out.println("\nYou got lost in the tunnel, pure darkness envelops your vision. Then others never found you again.");
        delay(1500);
        System.out.println("\nYou failed the test.");
        delay(1500);
        
        while (true) {
            System.out.println("\nPress enter two times to return to the menu");
            String input7 = scanner.nextLine();  
            if (input7.equals("")) {
                goToMenu.MainMenu(); // < (DUMMY MENU) ADD MENU HERE
            } else {
            	goToMenu.MainMenu(); // < (DUMMY MENU) ADD MENU HERE
            }
        }


    }

	static void correctDialogue(int correct) {
		switch (correct) {
			case 3:
				System.out.println("Character: \"I feel like I'm getting closer... just a bit more.\"");
				break;
			case 5:
				System.out.println("Character: \"I can feel wind... the exit must be near!\"");
				break;
			case 7:
				System.out.println("Character: \"I see a glimmer of light... almost there!\"");
				break;
			case 9:
				System.out.println("Character: \"I think I can see the light! I need to keep up, I can see the exit.\"");
				break;
		}
	}
	
	static void wrongDialogue(int wrong) {
		switch (wrong) {
			case 3:
				System.out.println("-------------TEST_WRONG-------------");
				break;
			case 5:
				System.out.println("-------------TEST_WRONG-------------");
				break;
			case 7:
				System.out.println("-------------TEST_WRONG-------------");
				break;
			case 10:
				System.out.println("-------------TEST_WRONG-------------");
				break;
		}
	}
	
	static void epilogue() {
		System.out.println("\nYou escaped the tunnel. Panting and sweating but thankful that you found your way out.");
		delay(1500);
		System.out.println("\nNarrator: Congrats! You passed the test, You may now proceed to the next phase.");
		delay(1500);
		while (true) {
			
			System.out.println("\nPress ENTER to proceed.");
			String nextPhase = scanner.nextLine();
			
			if (nextPhase.equalsIgnoreCase("")) {
				System.out.println("---------NEXT PHASE CONTENT--------");
				//<--------- NEXT PHASE METHOD HERE 
				break;
			}
		}
	}
	
	static void prologue() {
        System.out.println("\nHunter Exam Stage 1: Tunnel Run");
        delay(1500);
        System.out.println("Narrator: Welcome, examinee. Your first challenge lies ahead...");
        delay(1500);
        System.out.println("Narrator: You and others enter a dark, endless tunnel. Only the persistent reach the light...");
        delay(1500);
        System.out.println("\n(Press ENTER to begin your run through the tunnel)");
        scanner.nextLine();

	}
	
	static void failedTest() {
		System.out.println("\nYou got lost in the tunnel, pure darkness envelops your vision. Then others never found you again.");
		delay(1500);
		
		while (true) {
			System.out.println("\nPRESS ENTER TO MENU");
			String goMenu = scanner.nextLine();
			
			if (goMenu.equalsIgnoreCase("")) {
				goToMenu.MainMenu(); // < (DUMMY MENU) ADD MENU HERE
				
			}
		}

	}
	
	static void delay(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
	}
}	
