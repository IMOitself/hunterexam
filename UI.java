public class UI {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    public static void printBox(String text) {
        int textLength = text.length();
        System.out.println("╔" + "═".repeat(textLength + 2) + "╗");
        System.out.println("║" + " " + text + " " + "║");
        System.out.println("╚" + "═".repeat(textLength + 2) + "╝");
    }
}
