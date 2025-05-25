import java.util.Scanner;
import java.util.Random;

public class _PhaseFinal {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static int playerHP = 100;
    static int enemyHP = 100;

    static String chosenEnemy = "";
    static String chosenEnemyDialog = "";

    static String[] enemies = {
        "Gon",
        "Killua",
        "Kurapika",
        "Leorio",
        "Hisoka",
        "Gittarackur",
        "Hanzo",
        "Bodoro",
        "Pokkle"
    };

    static String[] enemyDialogs = {
        "Gon: Wow! This is amazing! Right, Killua? \nKillua: Yeah..",
        "Killua: Hmph. So this is it?",
        "Kurapika: My objective is clear. I will not be swayed.",
        "Leorio: Alright, alright, I get it! Sheesh!",
        "Hisoka: Heh>:)",
        "* Gittarackur is revealed to be Illumi * \nIllumi: Killua. Come home.",
        "Hanzo: My training is second to none!",
        "Bodoro: ...",
        "Pokkle: Okay, my arrows should be effective against this type...",
    };

    public static void exampleScreen(Scanner scanner){
        UI.clearScreen();
        narratorScreen(scanner);
        enemyChooseScreen(scanner);
        gameScreen(scanner);
    }

    public static void narratorScreen(Scanner scanner){
        String[] narratorLines = {
            "Netero: Everyone rested up? Good. Now, then.",
            "For the Final Phase of the Hunter Exam,\nwe will be competing in a one-on-one tournament.",
            "Now, for the rules of the tournament:",
            "1. You must win by making your opponent concede.",
            "2. Killing your opponent is strictly forbidden.",
            "\nPress Enter To Continue...",
        };

        for (String line : narratorLines) {
            System.out.println(line);
            scanner.nextLine();
        }
    }

    public static void enemyChooseScreen(Scanner scanner){
        int randomEnemyIndex = random.nextInt(enemies.length);
        chosenEnemy = enemies[randomEnemyIndex];
        chosenEnemyDialog = enemyDialogs[randomEnemyIndex];

        UI.clearScreen();
        UI.printBox("Enemy: " + chosenEnemy);
        System.out.println(chosenEnemyDialog);
        System.out.println("\nPress Enter To Continue...");
        scanner.nextLine();

        if (chosenEnemy.equals("Gittarackur")) chosenEnemy = "Illumi";
    }

    public static void gameScreen(Scanner scanner) {
        UI.clearScreen();
        while (playerHP > 0 && enemyHP > 0) {
            displayStatus();
            System.out.println("What will you do?");
            UI.printBox("1. Attack\n2. Talk\n3. Throw/Distract\n4. Run/Hide");

            String choice = scanner.nextLine().trim();

            String result = evaluateChoice(choice);
            UI.printBox(result);

            System.out.println("\nPress Enter To Continue...");
            scanner.nextLine();
            UI.clearScreen();
        }

        displayStatus();

        if (playerHP <= 0) {
            UI.printBox("You collapsed. Exam failed.");
        } else {
            UI.printBox("Enemy steps back and disappears. You passed the final test.");
        }

        System.out.println("\nPress Enter To Continue...");
        playerHP = 100;
        enemyHP = 100;
        scanner.nextLine();
        UI.clearScreen();
        _Intro.titleScreen(scanner);
    }

    static String evaluateChoice(String choice) {
        switch (choice) {
            case "1":
                playerHP -= 50;
                return "You tried to attack directly... Enemy countered. -50 HP";
            case "2":
                if (random.nextInt(100) < 60) {
                    enemyHP -= 50;
                    return "You talk calmly. Enemy hesitates. -50 Enemy HP";
                } else {
                    playerHP -= 20;
                    return "Enemy ignores your words. -20 HP";
                }
            case "3":
                enemyHP -= 30;
                return "You distracted the enemy successfully. -30 Enemy HP";
            case "4":
                if (random.nextInt(100) < 50) {
                    return "You ran and avoided damage.";
                } else {
                    playerHP -= 30;
                    return "You tripped while running. Enemy struck. -30 HP";
                }
            default:
                playerHP -= 40;
                return "You hesitated or made an invalid choice. Enemy attacked. -40 HP";
        }
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
            System.out.printf("   %-10s   %-10s\n", player[i], enemy[i]);
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
}

