import java.util.Scanner;

public class _EndScreen {
    public static void main(Scanner scanner){
        UI.clearScreen();
        String[] lines = {
            "╔════════════════════════════════════════╗",
            "║                                        ║",
            "║ ██████         ██████████       ██████ ║",
            "║   █              ███████            █  ║",
            "║    ██         █████▓▓█████        ██   ║",
            "║      ██      ████▓▓▓▓▓▓████     ██     ║",
            "║        ██  █████▓▓▓▓▓▓▓▓████  ██       ║",
            "║         ██████▓▓▓▓▓▓▓▓▓▓▓█████         ║",
            "║         █████▓▓▓▓▓▓▓▓▓▓▓▓▓▓████        ║",
            "║       █████  ██▓▓▓▓▓▓▓▓▓▓██ ████       ║",
            "║      ████      ██▓▓▓▓▓▓██    █████     ║",
            "║    █████         ██▓▓██        ████    ║",
            "║   ████             ██           ████   ║",
            "║ ███████        ██████████      ███████ ║",
            "║                                        ║",
            "║                                        ║",
            "║ █ ██ █ █ █ ██  █ █ ██ █ █  ██ █ █ █ ██ ║",
            "║ █ ██ █ █ █ ██  █ █ ██ █ █  ██ █ █ █ ██ ║",
            "║ █ ██ █ █ █ ██  █ █ ██ █ █  ██ █ █ █ ██ ║",
            "║                                        ║",
            "║ ┌────────────────────────────────────┐ ║",
            addUsername(),
            "║ └────────────────────────────────────┘ ║",
            "║ ┌────────────────────────────────────┐ ║",
            addScore(),
            "║ │                                    │ ║",
            "║ │In case of loss or theft of the card│ ║",
            "║ │it will not be replaced             │ ║",
            "║ └────────────────────────────────────┘ ║",
            "╚════════════════════════════════════════╝"
        };
        System.out.print("\033[33m");
        for (String line : lines) {
            System.out.println(line);
            UI.delay(150);
        }
        System.out.print("\033[0m");

        UI.printGreyText("\nPress Enter To Exit...");
        scanner.nextLine();
        _Intro.homeScreen(scanner);
    }

    static String addUsername(){
        return centerString(Player.username);
    }

    static String addScore(){
        return centerString("Total Score: " + Player.currentScore);
    }

    private static String centerString(String content){
        String frame = "║ │                                     │ ║";

        // Calculate the effective width for the content (inside '│' and '│')
        int effectiveWidth = frame.length() - "║ │ ".length() - " │ ║".length();

        // Calculate padding
        int contentLen = content.length();
        int totalPadding = effectiveWidth - contentLen;
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        // Construct the centered string
        String centeredContent = String.format("%" + leftPadding + "s%s%" + rightPadding + "s", "", content, "");
        return "║ │ " + centeredContent + "│ ║";
    }
}