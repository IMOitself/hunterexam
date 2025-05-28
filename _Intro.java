import java.util.Scanner;

public class _Intro {

    public static void printTitle(){
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
        System.out.println();
    }

    public static void titleScreen(Scanner scanner){
        UI.clearScreen();
        printTitle();
        System.out.println("             Press Enter to continue...             ");
        scanner.nextLine();
    }

    public static void mainMenu(Scanner scanner){
        String input = "";
        
        do {
            UI.clearScreen();
            printTitle();
            UI.printBox("0. test hehe\n1. Login\n2. Register\n3. Exit");
            input = scanner.nextLine();

        } while (!input.equals("0") && !input.equals("1") && !input.equals("2") && !input.equals("3"));

        switch(input){
            case "0":
                testScreen(scanner);
                break;
            case "1":
                UI.printBox("coming soon.");
                UI.delay(500);
                mainMenu(scanner);
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
            UI.clearScreen();
            UI.printBox("Create Your Username:");
            input = scanner.nextLine();
        } while (input.isEmpty());

        UI.clearScreen();
        UI.printBox("Create Your Username: " + input);

        UI.delay(500);
        
        UI.clearScreen();
        UI.printBox("Welcome To Hunter Exam, " + input + "!\n\ncoming soon...");
        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();
        mainMenu(scanner);
    }

    public static void testScreen(Scanner scanner){
        String input = "";
        
        do {
            UI.clearScreen();
            UI.printBox("1. Phase 1\n2. Phase 2\n3. Phase 3\n4. Phase 4\n5. Final\n6. Back");
            input = scanner.nextLine();

        } while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6"));

        switch(input){
            case "1":
                _Phase1.exampleScreen(scanner);
                break;
            case "2":
                _Phase2.exampleScreen(scanner);
                break;
            case "3":
                _Phase3.exampleScreen(scanner);
                break;
            case "4":
                _Phase4.exampleScreen(scanner);
                break;
            case "5":
                _PhaseFinal.exampleScreen(scanner);
                break;
            case "6":
                mainMenu(scanner);
                break;
        }
    }

    public static void homeScreen(Scanner scanner){
        titleScreen(scanner);
        mainMenu(scanner);
    }
}
