import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // _Intro
        _Intro.titleScreen(scanner);

        if(SQL.canConnect()){
            SQL.run("USE hunter_exam;");
            UI.delay(250);
            _Intro.mainMenu(scanner);
        }
        else{
            System.out.println("Connection failed. Press Enter to exit...");
            scanner.nextLine();
        }
        
        scanner.close();
    }
}
