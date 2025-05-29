import java.util.Scanner;

public class _Intro {

    public static void printTitle() {
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

    public static void titleScreen(Scanner scanner) {
        UI.clearScreen();
        printTitle();
        UI.printGreyText("             Press Enter to continue...             ");
        scanner.nextLine();
    }

    public static void mainMenu(Scanner scanner) {
        String input = "";
        UI.clearScreen();
        printTitle();
		UI.colorGrey();
		UI.printBox(Player.getTopPlayers());
		UI.colorReset();
        UI.printBox("1. Login\n2. Register\n3. Exit");
        input = scanner.nextLine();

        switch (input) {
            case "1":
                loginScreen(scanner);
                break;
            case "2":
                registerScreen(scanner);
                break;
            case "3":
                break;
            default:
                mainMenu(scanner);
                break;
        }
    }

    public static void registerScreen(Scanner scanner) {
        UI.clearScreen();
        UI.printBox("Create Your Username:");
        String username = scanner.nextLine();

        if (username.isEmpty()) {
            registerScreen(scanner);
        }
        else if(Player.isUsernameExists(username)){
            UI.clearScreen();
            UI.printBox("Username Already Taken.\nPlease Try Again.");
            UI.delay(500);
            registerScreen(scanner);
        }
        else {
            UI.clearScreen();
            UI.printBox("Create Your Username: " + username + "\nCreate Your Password:");
            String password = scanner.nextLine();
            UI.clearScreen();
            UI.printBox("Create Your Username: " + username + "\nCreate Your Password: " + password);
            UI.delay(750);

            Player.register(username, password);

            if(Player.canLogin(username, password)){
                UI.clearScreen();
                UI.printBox("Welcome To Hunter Exam, " + username + "!");
                UI.printGreyText("\nPress Enter To Continue...");
                scanner.nextLine();
                _PlayerScreen.exampleScreen(scanner);
            }else{
                mainMenu(scanner);
            }
        }
    }

    public static void loginScreen(Scanner scanner){
        UI.clearScreen();
        UI.printBox("Username:");
        String username = scanner.nextLine();

        if (username.isEmpty()) {
            loginScreen(scanner);
        }
        else {
            UI.clearScreen();
            UI.printBox("Username: " + username + "\nPassword:");
            String password = scanner.nextLine();

            if(Player.canLogin(username, password)){
                UI.clearScreen();
                UI.printBox("Welcome Back, " + username);
                UI.printGreyText("\nPress Enter To Continue...");
                scanner.nextLine();
                _PlayerScreen.exampleScreen(scanner);
            }
            else{
                scanner.nextLine();
                mainMenu(scanner);
            }
        }
    }

    public static void homeScreen(Scanner scanner) {
        titleScreen(scanner);
        mainMenu(scanner);
    }
}
