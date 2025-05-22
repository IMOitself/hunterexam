import java.util.Scanner;

public class _Intro {

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
        UI.clearScreen();
        printStartMenu();
        scanner.nextLine();
    }

    public static void mainMenu(Scanner scanner){
        String input = "";
        do {
            UI.clearScreen();
            UI.printBox("1. Login");
            UI.printBox("2. Register");
            UI.printBox("3. Exit");
            System.out.println("\nPress Enter To Continue...");
            input = scanner.nextLine();
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3"));

        if(input.equals("1")){
            UI.printBox("soon.");
                try {
                    Thread.sleep(500);
                    mainMenu(scanner);
                } catch (InterruptedException e) {}
        }

        if(input.equals("2")){
            registerScreen(scanner);
        }
    }

    public static void registerScreen(Scanner scanner){
        String input = "";
        do {
            UI.clearScreen();
            UI.printBox("Create Your Username:");
            input = scanner.nextLine();
        } while (!input.equals("Gon"));

        UI.clearScreen();
        UI.printBox("Create Your Username: " + input);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        UI.clearScreen();
        UI.printBox("Welcome To Hunter Exam, " + input + "!");
        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();
    }
}
