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

    public static void rpsUI() {
        try {
            // UI DISPLAY FOR JAJANKEN 
            String[] rockHand = {
                "    _______      _______    ",
                "---'   ____)    (____   '---",
                "      (_____)  (_____)      ",
                "      (_____)  (____)       ",
                "      (____)   (____)       ",
                "---.__(___)     (___)__.---"
            };
    
            String[] paperHand = {
                "    _______                 _______    ",
                "---'   ____)____       ____(____   '---",
                "          ______)     (______          ",
                "          _______)   (_______          ",
                "         _______)     (_______         ",
                "---.__________)        (__________.--- "
            };
    
            String[] scissorsHand = {
                "    _______                 _______     ",
                "---'   ____)____       ____(____        ",
                "          ______)     (______           ",
                "       __________)   (__________        ",
                "      (____)               (____        ",
                "---.__(___)                 (___)__.--- "
            };
    
            
            clearScreen();
            
            System.out.println("\nRock...");
            for (String line : rockHand) {
                System.out.println(line);
            }
            delay(1000);
            
            clearScreen();
            
            System.out.println("\nPaper...");
            for (String line : paperHand) {
                System.out.println(line);
            }
            delay(1000);
            clearScreen();
            
            System.out.println("\nScissors...");
            for (String line : scissorsHand) {
                System.out.println(line);
            }
            delay(1000);
            clearScreen();
            
            System.out.println("\nShoot!");
            delay(500);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
