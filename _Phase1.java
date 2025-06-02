import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

public class _Phase1 {
	static Scanner scanner = new Scanner(System.in);
	
	static int correctCount = 0;
	static int wrongInput = 0;
	public static final int TIME_LIMIT = 10; // seconds

    public static Timer timer;
    public static int timeLeft;
    public static boolean isRunning = true;
    public static List<String> wordsToGuess = new ArrayList<>();
    public static int currentWordIndex = 0;
    static volatile boolean timedOut = false;
	public static void main(String[] args) {
		
		UI.clearScreen();
        System.out.println("\n==============================================");
        System.out.println("        HUNTER x HUNTER - SPEED CHALLENGE");
        System.out.println("             Phase 1 of Hunter Exam");
        System.out.println("==============================================");
        UI.printGreyText("\nPress enter to continue...");
        scanner.nextLine();
		
		while (true) {
            UI.clearScreen();
            System.out.println("\n==============================================");
            System.out.println("        HUNTER x HUNTER - SPEED CHALLENGE");
            System.out.println("             Phase 1 of Hunter Exam");
            System.out.println("==============================================\n");

			UI.clearScreen();
            UI.printBox("=== DEMO MENU ===\nSELECT DIFFICULTY\n(0) EASY\n(1) NORMAL\n(2) HARD");
            System.out.print("Input: ");
        	
            String mainInput = scanner.nextLine();
            
        	if (mainInput.equals("0")) {
        		startGameEasy();
        		break;
        	}
        	if (mainInput.equals("1")) {
        		startGameNorm();
        		break;
        	}
           	if (mainInput.equals("2")) {
        		startGamediff();
        		break;
        	}
        }
        scanner.close();

	}
	
	public static void startTimer() {
	    timer = new Timer();
	    timeLeft = TIME_LIMIT;

	    timer.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	            timeLeft--;
//	            System.out.print(timeLeft + " ");

	            if (timeLeft == 0) {
                    timer.cancel();
                    isRunning = false;
					timedOut = true;
				
	            }
	        }
	    }, 1000, 1000);
	}
	
    public static void resetTimer() {
        timer.cancel();  // Stop current timer
        startTimer();    // Start new timer
    }
    
    static void gameOverDueToTimeout() {
		timer.cancel();
    	UI.clearScreen();
        System.out.println("\nYou got lost in the tunnel, pure darkness envelops your vision.");
		UI.delay(500);
		System.out.println(">>");

		scanner.nextLine();
		UI.clearScreen(); 
        UI.printBox("You failed the test.");
		UI.delay(500);
		System.out.println(">>");

        scanner.nextLine(); 
		UI.clearScreen();
        UI.printGreyText("\nPress enter to return to the menu");

		scanner.nextLine(); 
		_PlayerScreen.main(scanner);
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
				System.out.println("Character: What...? it feels like i've been here before.");
				break;
			case 5:
				System.out.println("Character: I know this place... I just need to follow this path.");
				break;
			case 7:
				System.out.println("Character: *panting* I have to keep going... But I'm lost, I don't know where to go.");
				break;
			case 10:
				System.out.println("Character: I'm tired...");
				break;
		}
	}
	
	static void epilogue() {
		
		UI.clearScreen();
		System.out.println("\nYou escaped the tunnel. Panting and sweating but thankful that you found your way out.");
		UI.delay(500);
		System.out.println(">>");

		
		scanner.nextLine();
		UI.clearScreen();  
		System.out.println("\nNarrator: Congrats! You passed the test, You may now proceed to the next phase.");
		UI.delay(500);
		System.out.println(">>");

		
		scanner.nextLine();
		UI.clearScreen();  
		UI.printGreyText("\nPress enter to go to the next phase");
		scanner.nextLine(); 
        _Phase2.exampleScreen(scanner);
	}
	
	static void prologue() {
		
		UI.clearScreen();
        System.out.println("\nHunter Exam Stage 1: Tunnel Run");
		UI.delay(500);
		System.out.println(">>");

	
		scanner.nextLine();
		UI.clearScreen(); 

        System.out.println("\nNarrator: Welcome, examinee. Your first challenge lies ahead...");
		UI.delay(500);
		System.out.println(">>");


		scanner.nextLine();
		UI.clearScreen(); 

        System.out.println("\nNarrator: You and others enter a dark, endless tunnel. Only the persistent reach the light...");
		UI.delay(500);
		System.out.println(">>");

		
		scanner.nextLine();
		UI.clearScreen();  

        UI.printGreyText("\nPress ENTER to begin your run through the tunnel");
        scanner.nextLine();

	}
	
	static void failedTest() {
		
		UI.clearScreen();
		System.out.println("\nYou got lost in the tunnel, pure darkness envelops your vision. Then others never found you again.");
		UI.delay(500);
		System.out.println(">>");

		
		scanner.nextLine();
		UI.clearScreen();  
		
		UI.printBox("You failed the test.");
		UI.delay(500);
		System.out.println(">>");

		
		scanner.nextLine();
		UI.clearScreen();  
		
		UI.printGreyText("\nPress enter to return to the menu");
		scanner.nextLine(); 
		_PlayerScreen.main(scanner);
	}
	
	static void startGameEasy() {
	    prologue(); //<----- will run the prologue first
	    
	    UI.clearScreen();
	    System.out.println("You have 10 seconds\n");

        wordsToGuess = SQL.runGetResult("SELECT word FROM p1easy ORDER BY RAND();");
	    //VARIABLE1      
	    String input1 = "";
	    //VARIABLE2
        correctCount = 0;
        wrongInput = 0;
            
	    startTimer(); // TIMER STARTS 
	    while (isRunning) {
            String word = wordsToGuess.get(currentWordIndex);
            System.out.println("Word to match: " + word); // Print word before asking for input
            System.out.print("Input here: ");
            input1 = scanner.next();
	        
	        //MAIN CONDITION 
		    if (input1.equalsIgnoreCase(word)) { //<------ IF THE INPUT IS CORRECT	
		        UI.printBox("CORRECT");
		        correctCount ++;
		        wrongInput = 0;
		        
		        correctDialogue(correctCount);
		        resetTimer(); // <------- reset timer for every correct input	
				UI.clearScreen();	        	
		    } else { //<------ IF THE INPUT IS WRONG
		        UI.printBox("WRONG");
		        wrongInput ++;
		        wrongDialogue(wrongInput); 
				UI.clearScreen();
		    }
            scanner.nextLine();

		    if (wrongInput == 10) { 
		        timer.cancel();
		        failedTest();
		        break;
		    }
		    if (correctCount == 10) {
		        timer.cancel();
		        epilogue();
		        break;
		    }
	        // timer.cancel();
	        // scanner.close();
		    currentWordIndex++;
	    }
	}	      

    static void startGameNorm() {
	    prologue(); //<----- will run the prologue first
	    
	    UI.clearScreen();
	    System.out.println("You have 10 seconds\n");

        wordsToGuess = SQL.runGetResult("SELECT word FROM p1norm ORDER BY RAND();");
	    //VARIABLE1      
	    String input1 = "";
	    //VARIABLE2
        correctCount = 0;
        wrongInput = 0;
            
	    startTimer(); // TIMER STARTS 
	    while (isRunning) {
			if (timedOut){
				gameOverDueToTimeout();
				break;
			}


            String word = wordsToGuess.get(currentWordIndex);
            System.out.println("Word to match: " + word); // Print word before asking for input
            System.out.print("Input here: ");
            input1 = scanner.next();

			
	        
	        //MAIN CONDITION 
		    if (input1.equalsIgnoreCase(word)) { //<------ IF THE INPUT IS CORRECT	
		        UI.printBox("CORRECT");
		        correctCount ++;
		        wrongInput = 0;
		        	
		        correctDialogue(correctCount);
		        resetTimer(); // <------- reset timer for every correct input
				UI.clearScreen();		        	
		    } else { //<------ IF THE INPUT IS WRONG
		        UI.printBox("WRONG");
		        wrongInput ++;
		        wrongDialogue(wrongInput); 
				UI.clearScreen();
		    }
            scanner.nextLine();

		    if (wrongInput == 10) { 
		        timer.cancel();
		        failedTest();
		        break;
		    }
			else
		    if (correctCount == 10) {
		        timer.cancel();
		        epilogue();
		        break;
		    }
            currentWordIndex++;
	    }
	}

    static void startGamediff() {
	    prologue(); //<----- will run the prologue first
	    
	    UI.clearScreen();
	    System.out.println("You have 10 seconds\n");

        wordsToGuess = SQL.runGetResult("SELECT word FROM p1diff ORDER BY RAND();");
	    //VARIABLE1      
	    String input1 = "";
	    //VARIABLE2
        correctCount = 0;
        wrongInput = 0;
            
	    startTimer(); // TIMER STARTS 
	    while (isRunning) {
            String word = wordsToGuess.get(currentWordIndex);
            System.out.println("Word to match: " + word); // Print word before asking for input
            System.out.print("Input here: ");
            input1 = scanner.next();
	        
	        //MAIN CONDITION 
		    if (input1.equalsIgnoreCase(word)) { //<------ IF THE INPUT IS CORRECT	
		        UI.printBox("CORRECT");
		        correctCount ++;
		        wrongInput = 0;
		        	
		        correctDialogue(correctCount);
		        resetTimer(); // <------- reset timer for every correct input
				UI.clearScreen();		        	
		    } else { //<------ IF THE INPUT IS WRONG
		        UI.printBox("WRONG");
		        wrongInput ++;
		        wrongDialogue(wrongInput); 
				UI.clearScreen();
		    }
            scanner.nextLine();

		    if (wrongInput == 10) { 
		        timer.cancel();
		        failedTest();
		        break;
		    } else
		    if (correctCount == 10) {
		        timer.cancel();
		        epilogue();
		        break;
		    }
            currentWordIndex++;
	    }
	}

}	
