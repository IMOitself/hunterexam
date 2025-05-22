import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // _Intro
        _Intro.titleScreen(scanner);
        _Intro.mainMenu(scanner);
        
        scanner.close();
    }
}
