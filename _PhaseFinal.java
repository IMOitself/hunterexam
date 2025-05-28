import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class _PhaseFinal {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static int playerHP = 100;
    static int enemyHP = 100;

    static String chosenEnemy = "";
    static String chosenEnemyDialog = "";

    static List<String> enemyNames = new ArrayList<>();
    static List<String> enemyDialogs = new ArrayList<>();
    static List<String> attackActions = new ArrayList<>();
    static List<String> talkActions = new ArrayList<>();
    static List<String> distractActions = new ArrayList<>();
    static List<String> runActions = new ArrayList<>();

    public static void exampleScreen(Scanner scanner){
        loadSQLvariables();
        UI.clearScreen();
        narratorScreen(scanner);
        enemyChooseScreen(scanner);
        gameScreen(scanner);
    }

    public static void loadSQLvariables(){
        enemyNames = SQL.runGetResult("SELECT name FROM p5enemies;");
        enemyDialogs = SQL.runGetResult("SELECT dialog FROM p5enemies;");

        int randomEnemyIndex = random.nextInt(enemyNames.size());
        chosenEnemy = enemyNames.get(randomEnemyIndex);
        chosenEnemyDialog = enemyDialogs.get(randomEnemyIndex);

        attackActions = SQL.runGetResultAll("SELECT * FROM p5actions WHERE action_type_id = 1;");
        talkActions = SQL.runGetResultAll("SELECT * FROM p5actions WHERE action_type_id = 2;");
        distractActions = SQL.runGetResultAll("SELECT * FROM p5actions WHERE action_type_id = 3;");
        runActions = SQL.runGetResultAll("SELECT * FROM p5actions WHERE action_type_id = 4;");
    }

    public static void narratorScreen(Scanner scanner){
        String[] narratorLines = {
            "Netero: Everyone rested up? Good. Now, then.",
            "For the Final Phase of the Hunter Exam,\nwe will be competing in a one-on-one tournament.",
            "Now, for the rules of the tournament:",
            "1. You must win by making your opponent concede.\n2. Killing your opponent is strictly forbidden.",
            "\nPress Enter To Continue...",
        };

        for (String line : narratorLines) {
            System.out.print(line + "\n");
            scanner.nextLine();
        }
    }

    public static void enemyChooseScreen(Scanner scanner){
        UI.clearScreen();
        displayStatus();
        UI.printBox("Enemy: " + chosenEnemy);
        System.out.println(chosenEnemyDialog);
        scanner.nextLine();

        if (chosenEnemy.equals("Gittarackur")) chosenEnemy = "Illumi";
    }

    public static void gameScreen(Scanner scanner) {
        String input = "";
        UI.clearScreen();
        displayStatus();
        UI.printBox("1. Attack\n2. Talk\n3. Distract\n4. Run");
        input = scanner.nextLine();

        switch (input) {
            case "1":
            case "2":
            case "3":
            case "4":
                String result = evaluateChoice(input);
                UI.printBox(result);
                System.out.println("\nPress Enter To Continue...");
                scanner.nextLine();
    
                if (playerHP > 0 && enemyHP > 0){
                    gameScreen(scanner);
                }else{
                    gameEndScreen(scanner);
                }
                break;
            default:
                gameScreen(scanner);
                break;
        }
    }

    static String evaluateChoice(String choice) {
        String[] action = {};
        int index = 0;
        switch (choice) {
            case "1":
                index = random.nextInt(attackActions.size());
                action = attackActions.get(index).split("::");
                break;
            case "2":
                index = random.nextInt(talkActions.size());
                action = talkActions.get(index).split("::");
                break;
            case "3":
                index = random.nextInt(distractActions.size());
                action = distractActions.get(index).split("::");
                break;
            case "4":
                index = random.nextInt(runActions.size());
                action = runActions.get(index).split("::");
                break;
        }

        if (action.length > 0) {
            enemyHP += Integer.parseInt(action[3]);
            playerHP += Integer.parseInt(action[4]);
            return action[2];
        }
        return "invalid.";
    }

    static void displayStatus() {
        System.out.println("\nPlayer HP: " + playerHP + " | Enemy HP: " + enemyHP);
        System.out.println("\n    YOU          " + chosenEnemy);
        displayStickmenSideBySide(playerHP, enemyHP);
    }

    static void displayStickmenSideBySide(int playerHP, int enemyHP) {
        String[] player = getStickmanLines(playerHP);
        String[] enemy = getStickmanLines(enemyHP);
        for (int i = 0; i < player.length; i++) {
            System.out.print("   ");
            System.out.print(player[i]);
            System.out.print("        ");
            System.out.println(enemy[i]);
        }
        System.out.println();
    }

    static String[] getStickmanLines(int hp) {
        if (hp > 70) {
            return new String[]{
                "  O  ",
                " /|\\ ",
                " / \\ "
            };
        } else if (hp > 40) {
            return new String[]{
                "  O  ",
                " /|  ",
                " /   "
            };
        } else if (hp > 0) {
            return new String[]{
                "  o  ",
                " /   ",
                "     "
            };
        } else {
            return new String[]{
                "  x  ",
                "     ",
                "RIP  "
            };
        }
    }

    static void gameEndScreen(Scanner scanner){
        UI.clearScreen();
        displayStatus();
        if (playerHP <= 0) {
            UI.printBox("You collapsed. Exam failed.");
        } else
        if (enemyHP < 0) {
            UI.printBox("You killed the enemy. Exam failed.");
        }
        else {
            UI.printBox("CONGRATULATIONS! You passed the hunter exam!");
        }

        System.out.println("\nPress Enter To Continue...");
        playerHP = 100;
        enemyHP = 100;
        scanner.nextLine();
        UI.clearScreen();
        _Intro.homeScreen(scanner);
    }
}

