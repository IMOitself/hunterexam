import java.util.Scanner;

public class NarrativeIntro {

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

    private static void printBox(String text) {
        int textLength = text.length();
        System.out.println("╔" + "═".repeat(textLength + 2) + "╗");
        System.out.println("║" + " " + text + " " + "║");
        System.out.println("╚" + "═".repeat(textLength + 2) + "╝");
    }

    private static void printStartMenu() {
        System.out.println();
        System.out.println("██╗  ██╗██╗   ██╗███╗   ██╗████████╗███████╗██████╗ ");
        System.out.println("██║  ██║██║   ██║████╗  ██║╚══██╔══╝██╔════╝██╔══██╗");
        System.out.println("███████║██║   ██║██╔██╗ ██║   ██║   █████╗  ██████╔╝");
        System.out.println("██╔══██║██║   ██║██║╚██╗██║   ██║   ██╔══╝  ██╔══██╗");
        System.out.println("██║  ██║╚██████╔╝██║ ╚████║   ██║   ███████╗██║  ██║");
        System.out.println("╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝   ╚═╝   ╚══════╝╚═╝  ╚═╝");
        System.out.println("                                                    ");
        System.out.println("        ███████╗██╗  ██╗ █████╗ ███╗   ███╗         ");
        System.out.println("        ██╔════╝╚██╗██╔╝██╔══██╗████╗ ████║         ");
        System.out.println("        █████╗   ╚███╔╝ ███████║██╔████╔██║         ");
        System.out.println("        ██╔══╝   ██╔██╗ ██╔══██║██║╚██╔╝██║         ");
        System.out.println("        ███████╗██╔╝ ██╗██║  ██║██║ ╚═╝ ██║         ");
        System.out.println("        ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝         ");
        System.out.println("\n           Press Enter to continue...             ");
    }

    public static void titleScreen(Scanner scanner){
        clearScreen();
        printStartMenu();
        scanner.nextLine();
    }

    public static void mainMenu(Scanner scanner){
        String input = "";
        do {
            clearScreen();
            printBox("1. Login");
            printBox("2. Register");
            printBox("3. Exit");
            System.out.println("\nPress Enter To Continue...");
            input = scanner.nextLine();
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3"));

        switch (input) {
            case "1":
                printBox("soon.");
                try {
                    Thread.sleep(500);
                    mainMenu(scanner);
                } catch (InterruptedException e) {}
                break;
            case "2":
                registerScreen(scanner);
                break;
            case "3":
                break;
        }
        
    }

    public static void registerScreen(Scanner scanner){
        String input = "";
        do {
            clearScreen();
            printBox("Create Your Username:");
            input = scanner.nextLine();
        } while (!input.equals("Gon"));

        clearScreen();
        printBox("Create Your Username: " + input);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        clearScreen();
        printBox("Welcome To Hunter Exam, " + input + "!");
        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();
    }
}
