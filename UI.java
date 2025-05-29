public class UI {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
	
	public static void printGreyText(String string){
		System.out.println("\033[2m" + string + "\033[0m");
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
}
