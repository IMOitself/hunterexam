import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class _PhaseFinal {
    static Scanner scanner;
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

    public static void main(Scanner scanner){
        Player.updatePhase(5);
        _PhaseFinal.scanner = scanner;
        loadSQLvariables();

        UI.clearScreen();
        System.out.println("\n==============================================");
        System.out.println("           HUNTER x HUNTER - PVP CHALLENGE");
        System.out.println("             Final Phase of Hunter Exam");
        System.out.println("==============================================");
        UI.printGreyText("\nPress enter to continue...");
        scanner.nextLine();

        narratorScreen(scanner);
        enemyChooseScreen(scanner);
        gameScreen(scanner);
    }

    public static void loadSQLvariables(){
        enemyNames = SQL.runGetResult("SELECT name FROM p5Enemies;");
        enemyDialogs = SQL.runGetResult("SELECT dialog FROM p5Enemies;");

        int randomEnemyIndex = random.nextInt(enemyNames.size());
        chosenEnemy = enemyNames.get(randomEnemyIndex);
        chosenEnemyDialog = enemyDialogs.get(randomEnemyIndex);

        attackActions = SQL.runGetResultAll("SELECT * FROM p5Actions WHERE action_type_id = 1;");
        talkActions = SQL.runGetResultAll("SELECT * FROM p5Actions WHERE action_type_id = 2;");
        distractActions = SQL.runGetResultAll("SELECT * FROM p5Actions WHERE action_type_id = 3;");
        runActions = SQL.runGetResultAll("SELECT * FROM p5Actions WHERE action_type_id = 4;");
    }

    public static void narratorScreen(Scanner scanner){
        String[] narratorLines = {
            "Netero: Everyone rested up? Good. Now, then.",
            "For the Final Phase of the Hunter Exam,\nwe will be competing in a one-on-one tournament.",
            "Now, for the rules of the tournament:",
            "1. You must win by making your opponent concede.\n2. Killing your opponent is strictly forbidden.",
        };

        for (String line : narratorLines) {
            System.out.print(line + "\n");
            scanner.nextLine();
        }
		
		UI.printGreyText("\nPress Enter To Continue...");
		scanner.nextLine();
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
                runChoiceAndPrintResult(input);
                UI.printGreyText("\nPress Enter To Continue...");
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

    static void runChoiceAndPrintResult(String choice) {
        String resultText = "";
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
        
        String hpChangeText = "";

        if (action.length > 0) {
            int enemyHPadd = Integer.parseInt(action[2]);
            int playerHPadd = Integer.parseInt(action[3]);

            hpChangeText = hpChangeText(enemyHPadd, playerHPadd);
            
            enemyHP += enemyHPadd;
            playerHP += playerHPadd;

            // add score based on damage
            Player.currentScore -= enemyHPadd;
            resultText = action[1];
        }
        UI.printBox(resultText + "\n\n" + hpChangeText);
    }

    static String hpChangeText(int enemyHPadd, int playerHPadd){
        String hpChangeText = "";
        if(enemyHPadd > 0) {
            hpChangeText = chosenEnemy + " +" + enemyHPadd;
        }else if (enemyHPadd < 0) {
            hpChangeText = chosenEnemy + " " + enemyHPadd;
        }
        if(playerHPadd > 0) {
            hpChangeText += " You +" + playerHPadd;
        }else if (playerHPadd < 0){
            hpChangeText += " You " + playerHPadd;
        }
        return hpChangeText;
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
        if (hp > 75) {
            return new String[]{
                "  O  ",
                " /|\\ ",
                " / \\ "
            };
        } else if (hp > 50) {
            return new String[]{
                "  O  ",
                " /|  ",
                " / \\ "
            };
        } else if (hp > 25) {
            return new String[]{
                "  O  ",
                "  |  ",
                " / \\ "
            };
        } else if (hp > 0) {
            return new String[]{
                "  o  ",
                "  |  ",
                " /   "
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
            Player.currentScore += 100;
        }

        Player.updateScore();

        UI.printGreyText("\nPress Enter To Continue...");
        playerHP = 100;
        enemyHP = 100;
        Player.updatePhase(1);
        scanner.nextLine();
        _Intro.homeScreen(scanner);
    }
}

