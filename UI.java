import java.util.HashMap;

public class UI {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
	
	public static void printGreyText(String string){
		System.out.println("\033[2m" + string + "\033[0m");
	}
	
	public static void colorGrey(){
		System.out.print("\033[2m");
	}
	
	public static void colorReset(){
		System.out.print("\033[0m");
	}

    public static void printBox(String text) {
        String[] textLines = text.split("\n");

        int maxLineLength = 0;
        for (String line : textLines) {
            maxLineLength = Math.max(maxLineLength, line.length());
        }

        String horizontalLine = "";
        for (int i = 0; i < maxLineLength + 2; i++) {
            horizontalLine += "═";
        }

        System.out.println("╔" + horizontalLine + "╗");
        for (String line : textLines) {
            int remainingSpace = (maxLineLength - line.length());

            for (int i = 0; i < remainingSpace; i++) {
                line += " ";
            }
            System.out.println("║" + " " + line + " " + "║");
        }
        System.out.println("╚" + horizontalLine + "╝");
    }

    public static void delay(int ms){
        try {
            Thread.sleep(ms);
        } catch (Exception e) {}
    }

    // UI DISPLAY FOR JAJANKEN 
    public static void printRPSStart() {
        UI.clearScreen();
        printRPSResult("ROCK", "ROCK");
        System.out.println("\n                  Rock...");
        UI.delay(500);
        
        UI.clearScreen();
        printRPSResult("PAPER", "PAPER");
        System.out.println("\n                   Paper...");
        UI.delay(500);
        
        UI.clearScreen();
        printRPSResult("SCISSORS", "SCISSORS");
        System.out.println("\n                  Scissors...");
        UI.delay(500);
        
        UI.clearScreen();
        System.out.println("\n\n\n                    Shoot!");
        delay(500);
    }
    // JAJANKEN GAME UI
    public static void printRPSResult(String playerChoice, String computerChoice) {
        playerChoice = playerChoice.toUpperCase();
        computerChoice = computerChoice.toUpperCase();
        HashMap<String, String[]> playerHand = new HashMap<>();
        playerHand.put("ROCK", new String[] {
            "    ______  ",
            "---'   ___) ",
            "      (____)",
            "      (____)",
            "      (____) ",
            "---.__(___)  "
        });
        playerHand.put("PAPER", new String[] {
            "    _______       ",
            "---'   ____)____  ",
            "          ______) ",
            "          _______)",
            "         _______) ",
            "---.__________)   "
        });
        playerHand.put("SCISSORS", new String[] {
            "    __           ",
            "---'  |_________ ",
            "      |   ______)",
            "   |__|  _______)",
            "      (____)     ",
            "---.__(___)      "
        });
        HashMap<String, String[]> computerHand = new HashMap<>();
        computerHand.put("ROCK", new String[] {
            "  ______    ",
            " (___   '---",
            "(____)      ",
            "(____)      ",
            "(____)      ",
            " (___)__.---"
        });
        computerHand.put("PAPER", new String[] {
            "       _______    ",
            "  ____(____   '---",
            " (______          ",
            "(_______          ",
            " (_______         ",
            "   (__________.---"
        });
        computerHand.put("SCISSORS", new String[] {
            "           __    ",
            " _________|  '---",
            "(______   |      ",
            "(_______  |__|   ",
            "    (____)       ",
            "     (___)__.--- "
        });

        for (int i = 0; i < playerHand.get(playerChoice).length; i++) {
            System.out.print("   ");
            System.out.print(playerHand.get(playerChoice)[i]);
            System.out.print("        ");
            System.out.println(computerHand.get(computerChoice)[i]);
        }
    }
}
