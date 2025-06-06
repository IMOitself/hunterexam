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
            centerString("recieved upon completion of"),
            centerString("the hunter exam."),
            "║ └────────────────────────────────────┘ ║",
            "╚════════════════════════════════════════╝"
        };
        System.out.print("\033[33m");
        for (String line : lines) {
            System.out.println(line);
            UI.delay(150);
        }
        System.out.print("\033[0m");

        UI.printGreyText("\nPress Enter To Roll Credits...");
        scanner.nextLine();
        creditsScreen(scanner);
    }

    static void creditsScreen(Scanner scanner){
        UI.clearScreen();
        String[] lines = {
            "==============================================",
            "                    Credits",
            "==============================================",
            "\n",
            "            Phase 1 - SPEED CHALLENGE:",
            "",
            "              Karl Ashton Mahusay",
            "\n",
            "           Phase 2 - COOKING CHALLENGE:",
            "",
            "                sir Rey Austria",
            "\n",
            "          Phase 3 - TRICK TOWER CHALLENGE:",
            "",
            "                  JR Balmaceda",
            "\n",
            "            Phase 4 - Math CHALLENGE:",
            "",
            "                  sir Rey Austria",
            "\n",
            "           Final Phase - PVP CHALLENGE:",
            "",
            "                  Meynard Villar",
            "\n",
            "             Refactoring and Database:",
            "",
            "                 Russell Bautista",
            "\n",
            "                Team Hunter Exam:",
            "",
            "                   JR Balmaceda",
            "                  Meynard Villar",
            "                 Russell Bautista",
            "                  sir Rey Austria",
            "                Karl Ashton Mahusay"
        };
        for (String line : lines) {
            System.out.println(line);
            UI.delay(150);
        }

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