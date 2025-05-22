import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        NarrativeIntro.titleScreen(scanner);
        NarrativeIntro.mainMenu(scanner);
        
        scanner.close();
    }
}
