import java.util.Scanner;
import java.util.Random;

public class _Phase3 {
    private static int remainingHours = 72;
    private static boolean tonpaAlive = true;
    private static boolean tonpaInjured = false;
    private static boolean leorioPassed = true;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        displayIntro();
        initialDescent();
        enterTower();
        prisonerChallenges();
        finalChallenge();
        displayEnding();
    }

    public static void displayIntro() {
        System.out.println("\n==============================================");
        System.out.println("    HUNTER x HUNTER - TRICK TOWER CHALLENGE");
        System.out.println("             Phase 3 of Hunter Exam");
        System.out.println("==============================================");
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();

        System.out.println("\nThe airship lands on Trick Tower, a massive prison");
        System.out.println("where dangerous criminals are kept. Examiner Beans");
        System.out.println("explains your objective:");
        System.out.println("\n>> Reach the bottom within 72 hours <<");

        System.out.println("\nYour team: Gon, Killua, Kurapika, Leorio, and Tonpa");
        System.out.println("Press enter to begin your descent...");
        scanner.nextLine();
    }

    public static void initialDescent() {
        System.out.println("\n=== INITIAL DESCENT ===");
        System.out.println("Gon looks down the sheer tower walls. Kurapika warns:");
        System.out.println("\"Climbing down would be suicide!\"");

        System.out.println("\nOne of the examinees, a skilled rock climber, ignores");
        System.out.println("the warning and attempts to climb down the tower walls.");
        System.out.println("\nSuddenly, Six-legged Flying Beasts swoop down and");
        System.out.println("carry him away screaming!");
        System.out.println("\nTonpa mutters: \"That could have been any of us...\""); // i need a 1 second pause here
        System.out.println("Leorio glares at him: \"Shut up, Tonpa!\""); // also here need pause of 1 sec
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();

        System.out.println("\nYour group decides to search for a safer entrance...");
        System.out.println("Gon discovers a hidden tile entrance!");
        remainingHours -= 6;

        System.out.println("\nRemaining time: " + remainingHours + " hours");
        System.out.println("Press enter to continue...");
        scanner.nextLine();
    }

    public static void enterTower() {
        System.out.println("\n=== THE VOTING MECHANISM ===");
        System.out.println("You enter a room with five watches marked X and O.");
        System.out.println("Prison warden Lippo explains the 'majority rules' system:");
        System.out.println("- You must vote on decisions using X/O buttons");
        System.out.println("- You need all five members to proceed");
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();

        System.out.println("\nFirst vote: Open the door ahead?");
        System.out.println("Gon, Killua, Kurapika, and Leorio vote O (Yes)");
        System.out.println("Tonpa votes X (No) - he wants to sabotage you!");
        System.out.println("The door opens...");
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();

        System.out.println("\nSecond vote: Left or Right door?");
        System.out.println("Gon and Leorio choose Right (X)");
        System.out.println("Kurapika and Killua choose Left (O)");
        System.out.println("Tonpa votes randomly...");
        System.out.print("Your deciding vote (X/O): ");
        String vote = scanner.nextLine().toUpperCase();

        if (vote.equals("O")) {
            System.out.println("\nLeft door wins! Kurapika explains his reasoning:");
            System.out.println("'Most people choose right instinctively, so left might be better.'");
        } else {
            System.out.println("\nRight door wins! The group follows Gon's lead.");
        }

        System.out.println("\nBoth paths eventually converge to the same destination.");
        System.out.println("Press enter to face the prisoner challenges...");
        scanner.nextLine();
    }

    public static void prisonerChallenges() {
        System.out.println("\n=== PRISONER CHALLENGES ===");
        System.out.println("You enter a large arena with five prisoners.");
        System.out.println("Lippo explains the rules:");
        System.out.println("- You must win at least 3 challenges to proceed, or else.. penalty");
        System.out.println("- Prisoners get 1 year off sentence per hour they delay you");
        System.out.println("- Some matches are deathmatch but surrender is allowed");
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();

        // Challenge 1: Bendot vs Tonpa
        System.out.println("\n1st Challenge: Bendot (199 years - robbery/murder)");
        System.out.println("A hulking brute with bloodstained knuckles steps forward.");
        System.out.println("He cracks his neck and says: \"Deathmatch rules - fight or surrender!\"");
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();

        System.out.println("\nTonpa volunteers... \"Let me handle this rookie!\" he says with false bravado.");
        System.out.println("What should Tonpa do?");
        System.out.println("1. Surrender immediately");
        System.out.println("2. Fight (despite being clearly outmatched)");
        System.out.print("Choose (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("\nTonpa immediately bows his head in submission, his voice shaking: \"I surrender... I surrender...\"");
            System.out.println("Bendot spits on the ground: \"Worthless coward!\"");
            System.out.println("-2 hours deducted for quick resolution");
            remainingHours -= 2;

            System.out.println("\nLeorio suddenly grabs Tonpa by the collar!");
            System.out.println("\"You bastard! You just confirmed all my suspicions!\"");
            System.out.println("\"You've been sabotaging us this whole time!\"");
            System.out.println("\nPress enter to continue...");
            scanner.nextLine();

            System.out.println("Killua calmly stops Leorio: \"Actually, he made the right choice.\"");
            System.out.println("\nKillua coolly analyzes the situation: \"That stance... he was definitely a former military or mercenary.\"");
            System.out.println("\"They're trying to buy time - every hour we waste is a year off their sentences.\"");
            System.out.println("\"If Tonpa had fought, Bendot would have crushed his throat first\"");
            System.out.println("\"to prevent surrender, then tortured him slowly to death.\"");
            System.out.println("\nPress enter to continue..."); // change this to pause
            scanner.nextLine();

            System.out.println("Kurapika nods: \"Killua's right. This was the optimal outcome.\"");
            System.out.println("Leorio reluctantly releases Tonpa, still glaring.");
        } else {
            System.out.println("\nTonpa steps forward with shaky legs...");
            System.out.println("\nPress enter to see what happens...");
            scanner.nextLine();

            System.out.println("Before Tonpa can react, Bendot lunges with terrifying speed!");
            System.out.println("His massive hand CRUSHES Tonpa's throat!");
            System.out.println("\nPress enter to continue...");
            scanner.nextLine();

            System.out.println("Tonpa's eyes bulge as he tries to gasp for air...");
            System.out.println("Bendot whispers: \"No surrender for you, little man.\"");
            System.out.println("\nPress enter to continue...");
            scanner.nextLine();

            System.out.println("The brutal torture begins...");
            System.out.println("- Bendot methodically breaks Tonpa's fingers one by one");
            System.out.println("- He stomps on Tonpa's knees, shattering them");
            System.out.println("- He slowly twists Tonpa's arms until they snap");
            System.out.println("\nPress enter to continue...");
            scanner.nextLine();

            System.out.println("Gon looks away in horror as the torture continues for hours...");
            System.out.println("Finally, Bendot delivers the killing blow - a massive punch to the chest!");
            System.out.println("Tonpa's body goes limp, his ribcage completely caved in.");
            System.out.println("\nPress enter to continue...");
            scanner.nextLine();

            System.out.println("Bendot wipes his hands: \"That's 5 hours of my life back.\"");
            System.out.println("-5 hours deducted for the prolonged torture");
            remainingHours -= 5;

            System.out.println("\nKillua observes coldly: \"Those methods... i think he was a former military or mercenary.\"");
            System.out.println("Leorio is pale: \"That... that could have been any of us...\"");

            tonpaAlive = false;
        }

        // Challenge 2: Sedokan vs Gon
        System.out.println("\n2nd Challenge: Sedokan (149 years - serial bombings)");
        System.out.println("Gon steps forward. The game: Candle burning contest.");
        System.out.println("Sedokan offers a choice: long candle or short candle?");

        String candle;
        do {
            System.out.print("Choose (Long/Short): ");
            candle = scanner.nextLine().toLowerCase();
            if (!candle.equals("long") && !candle.equals("short")) {
                System.out.println("Invalid choice! Please enter 'Long' or 'Short'.");
            }
        } while (!candle.equals("long") && !candle.equals("short"));

        boolean choseLong = candle.equals("long");
        System.out.println("\nYou chose the " + (choseLong ? "long" : "short") + " candle...");

        if (choseLong) {
            System.out.println("The long candle is oil-soaked! It's burning faster!");
            System.out.println("Gon notices his candle isn't affected by wind...");
            System.out.println("Will he try to blow out Sedokan's candle? (Y/N)");
            System.out.print("Choose: ");
            String action = scanner.nextLine().toUpperCase();

            if (action.equals("Y")) {
                System.out.println("\nGon sprints and blows out Sedokan's candle!");
                System.out.println("Brilliant move! No time lost.");
            } else {
                System.out.println("\nGon hesitates and his candle burns out first!");
                System.out.println("Prisoners gain 5 hours.");
                remainingHours -= 5;
            }
        } else {
            System.out.println("The short candle burns normally - Gon wins easily!");
        }

        // Challenge 3: Majtani vs Kurapika
        System.out.println("\n3rd Challenge: Majtani (Fake Phantom Troupe member)");
        System.out.println("He boasts: 'I've killed 19 people - you'll be my 20th!'");
        System.out.println("Kurapika's eyes flash scarlet at the spider tattoo...");
        System.out.println("\nPress enter to see Kurapika's reaction...");
        scanner.nextLine();

        System.out.println("With one devastating punch, Kurapika knocks him out!");
        System.out.println("'A real Troupe tattoo has a number. Never mention them to me again.'");

        deadOrAliveGame();

        // Challenge 4: Rock-Paper-Scissors
        System.out.println("\n4th Challenge: Leroute's Mind Games");
        System.out.println("She challenges Leorio to Rock-Paper-Scissors");
        System.out.println("with 80 hours at stake! She claims she can read minds...");
        System.out.println("\nPress enter to begin the game...");
        scanner.nextLine();

        int playerWins = 0;
        int computerWins = 0;

        while (playerWins < 3 && computerWins < 3) {
            System.out.println("\nScore: You " + playerWins + " - " + computerWins + " Leroute");
            System.out.print("Choose (Rock/Paper/Scissors): ");
            String playerChoice = scanner.nextLine().toUpperCase();

            if (!playerChoice.equals("ROCK") && !playerChoice.equals("PAPER") && !playerChoice.equals("SCISSORS")) {
                System.out.println("Invalid choice! Try again.");
                continue;
            }

            String computerChoice;
            if (playerWins == 0 && computerWins == 0) {
                computerChoice = "PAPER";
            } else {
                String[] options = {"ROCK", "PAPER", "SCISSORS"};
                computerChoice = options[random.nextInt(3)];
            }

            System.out.println("Leroute chose: " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                System.out.println("Draw! Try again.");
            } else if ((playerChoice.equals("ROCK") && computerChoice.equals("SCISSORS")) ||
                    (playerChoice.equals("PAPER") && computerChoice.equals("ROCK")) ||
                    (playerChoice.equals("SCISSORS") && computerChoice.equals("PAPER"))) {
                System.out.println("You win this round!");
                playerWins++;
            } else {
                System.out.println("Leroute wins this round!");
                computerWins++;
            }
        }

        if (playerWins == 3) {
            System.out.println("\nYou defeated Leroute! No time lost.");
        } else {
            System.out.println("\nLeroute outplayed you! -50 hours penalty!");
            remainingHours -= 50;
        }

        // Challenge 5: Johness vs Killua PS: sorry natamad na ako mag isip ng mga mangyayari (-.-)
        System.out.println("\nFinal Challenge: Johness the Dissector");
        System.out.println("Killua faces the notorious serial killer...");
        System.out.println("\nPress enter to see the outcome...");
        scanner.nextLine();

        System.out.println("Before anyone can blink, Killua rips out Johness's heart!");
        System.out.println("Killua smiles with satisfaction.");

        System.out.println("\nYou won 3 challenges! Proceeding to next stage...");
        System.out.println("Remaining time: " + remainingHours + " hours");
        System.out.println("Press enter to continue...");
        scanner.nextLine();
    }

    public static void deadOrAliveGame() {
        System.out.println("\n=== DEAD OR ALIVE GAME ===");
        System.out.println("The prisoners claim Majtani is just unconscious...");
        System.out.println("Leroute (112 years - illegal gambling) proposes a bet:");
        System.out.println("- Bet hours against their sentence reduction");
        System.out.println("- Minimum 10 hours per bet");
        System.out.println("\nPress enter to continue...");
        scanner.nextLine();

        // First bet
        System.out.println("\nFirst bet: Is Majtani dead or alive?");
        System.out.print("Choose (Dead/Alive): ");
        String condition = scanner.nextLine();

        if (condition.equalsIgnoreCase("Dead")) {
            System.out.println("\nLeorio checks - he's unconscious but alive!");
            System.out.println("You lose 10 hours.");
            remainingHours -= 10;
        } else {
            System.out.println("\nLeorio confirms he's alive (but unconscious)");
            System.out.println("You win 10 hours!");
            remainingHours += 10;
        }

        // Second bet
        System.out.println("\nSecond bet: Is Majtani really unconscious?");
        System.out.println("Leorio suspects he's faking...");
        System.out.println("How to prove it?");
        System.out.println("1. Threaten to stab him");
        System.out.println("2. Pretend to throw him off the edge");
        System.out.print("Choose (1-2): ");
        int method = scanner.nextInt();
        scanner.nextLine();

        if (method == 1) {
            System.out.println("\nLeorio stabs near him - no reaction!");
            System.out.println("You lose 20 hours.");
            remainingHours -= 20;
        } else {
            System.out.println("\nLeorio pretends to toss him off the edge!");
            System.out.println("Majtani screams and reveals he was faking!");
            System.out.println("You win 40 hours!");
            remainingHours += 40;
        }
    }

    public static void finalChallenge() {
        System.out.println("\n=== FINAL CHALLENGE ===");
        System.out.println("With only " + remainingHours + " hours remaining...");
        System.out.println("You reach two final doors:");
        System.out.println("Door O: 45 hour path - all can pass");
        System.out.println("Door X: 3 minute path - only 3 can pass");
        System.out.println("\nPress enter to consider your options...");
        scanner.nextLine();

        System.out.println("\nWhat will you do?");
        System.out.println("1. Take Door O (safe but time-consuming)");
        System.out.println("2. Take Door X (risky but fast)");
        System.out.println("3. Find another way");
        System.out.print("Choose (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("\nYou choose the long path with everyone.");
                remainingHours -= 45;
                break;
            case 2:
                System.out.println("\nYou choose the short path but must leave 2 behind.");
                System.out.println("Gon, Killua and Kurapika go ahead.");
                System.out.println("Leorio and Tonpa are left behind fighting each other!");
                leorioPassed = false;
                remainingHours -= 1;
                break;
            case 3:
                System.out.println("\nYou search for another option...");
                System.out.println("Tonpa gets frustrated and attacks Leorio with an axe int the room!");
                System.out.println("Gon gets an idea from watching Tonpa's axe cutting the wall...");
                System.out.println("You break the wall between paths!");
                System.out.println("Everyone passes in just 10 hours!");
                remainingHours -= 10;
                break;
            default:
                System.out.println("\nInvalid choice! Defaulting to Door O.");
                remainingHours -= 45;
        }
    }

    public static void displayEnding() {
        System.out.println("\n=== HUNTER EXAM RESULTS ===");
        System.out.println("Time remaining: " + remainingHours + " hours");
        System.out.println("\nPress enter to see your results...");
        scanner.nextLine();

        if (remainingHours <= 0) {
            badEnding();
        } else if (remainingHours <= 24) {
            neutralEnding();
        } else {
            goodEnding();
        }

        System.out.println("\n=== TEAM STATUS ===");
        System.out.println("Gon: Passed");
        System.out.println("Killua: Passed");
        System.out.println("Kurapika: Passed");
        System.out.println("Leorio: " + (leorioPassed ? "Passed" : "Failed"));
        System.out.println("Tonpa: " + (tonpaAlive ? (tonpaInjured ? "Injured but passed" : "Passed") : "DEAD"));

        System.out.println("\nThank you for playing the Hunter Exam!");
    }

    public static void goodEnding() {
        System.out.println("\n╔══════════════╗");
        System.out.println("║  Good Ending ║");
        System.out.println("╚══════════════╝ ");

        System.out.println("\nEXCELLENT PERFORMANCE!");
        System.out.println("You've completed Phase 3 with plenty of time remaining!");
    }

    public static void neutralEnding() {
        System.out.println("\n╔══════════════╗");
        System.out.println("║  Neutral Ending ║");
        System.out.println("╚══════════════╝ ");

        System.out.println("\nYou passed the phase, but barely!");
    }

    public static void badEnding() {
        System.out.println("\n╔══════════════╗");
        System.out.println("║  Bad Ending ║");
        System.out.println("╚══════════════╝ ");

        System.out.println("\nTIME'S UP! YOU FAILED PHASE 3!");
    }
}